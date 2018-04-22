using System;
using System.IO;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Text.RegularExpressions;

namespace server.Model
{
    public class Client
    {
        public Client(TcpClient client)
        {
            Creation(client);
        
        }


        private void SendError(TcpClient client, int code)
        {
            string codeStr = code.ToString() + " " + ((HttpStatusCode)code);
            string html = "<html><body><h1>" + codeStr + "</h1></body></html>";
            string str = "HTTP/1.1 " + codeStr + "\nContent-type: text/html\nContent-Length:" + html.Length + "\n\n" + html;
            byte[] buffer = Encoding.ASCII.GetBytes(str);
            client.GetStream().Write(buffer, 0, buffer.Length);
            client.Close();
        }

        private void Creation(TcpClient client)
        {
            StringBuilder request = new StringBuilder();
            byte[] buffer = new byte[1024];
            int count;
            while ((count = client.GetStream().Read(buffer, 0, buffer.Length)) > 0)
            {
                request.Append(Encoding.ASCII.GetString(buffer, 0, count));
                if (request.ToString().IndexOf("\r\n\r\n", StringComparison.Ordinal) >= 0 || request.Length > 4096)
                {
                    break;
                }
            }

            Match reqMatch = Regex.Match(request.ToString(), @"^\w+\s+([^\s\?]+)[^\s]*\s+HTTP/.*|");

            if (reqMatch == Match.Empty)
            {
                SendError(client, 400);
                return;
            }

            
            string requestUri = reqMatch.Groups[1].Value;

            requestUri = Uri.UnescapeDataString(requestUri);

            if (requestUri.IndexOf("..") >= 0)
            {
                SendError(client, 400);
                return;
            }

            if (requestUri.EndsWith("/"))
            {
                requestUri += "index.html";
            }

            string filePath = "www/" + requestUri;

            if (!File.Exists(filePath))
            {
                SendError(client, 404);
                return;
            }

            string extension = requestUri.Substring(requestUri.LastIndexOf('.'));

            string contentType = "";

            switch (extension)
            {
                case ".htm":
                case ".html":
                    contentType = "text/html";
                    break;
                case ".css":
                    contentType = "text/stylesheet";
                    break;
                case ".js":
                    contentType = "text/javascript";
                    break;
                case ".jpg":
                    contentType = "image/jpeg";
                    break;
                case ".jpeg":
                case ".png":
                case ".gif":
                    contentType = "image/" + extension.Substring(1);
                    break;
                default:
                    if (extension.Length > 1)
                    {
                        contentType = "application/" + extension.Substring(1);
                    }
                    else
                    {
                        contentType = "application/unknown";
                    }
                    break;
            }

            FileStream fs;
            try
            {
                fs = new FileStream(filePath, FileMode.Open, FileAccess.Read, FileShare.Read);
            }
            catch (Exception)
            {
                SendError(client, 500);
                return;
            }

            string headers = "HTTP/1.1 200 OK\nContent-Type: " + contentType + "\nContent-Length: " + fs.Length + "\n\n";
            byte[] headersBuffer = Encoding.ASCII.GetBytes(headers);
            client.GetStream().Write(headersBuffer, 0, headersBuffer.Length);

            while (fs.Position < fs.Length)
            {
                count = fs.Read(buffer, 0, buffer.Length);
                client.GetStream().Write(buffer, 0, count);
            }

            fs.Close();
            client.Close();
        }
        
        
    }
}
using System;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace Lab4Ksis
{
    class Program
    {
        static void Main(string[] args)
        {
                      
            if (args[0] == "1")
            {
                FirstTask(8534, 512);
            }else if (args[0] == "2")
            {
                SecondTask(8534,512,10);
            }
            else
            {
                Console.WriteLine("Use 1 or 2");
            }


        }

        private static void FirstTask(int port, int size)
        {
            try
            {
                Socket s1 = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                IPEndPoint ipEP = new IPEndPoint(IPAddress.Parse("127.0.0.1"), port);
                
                Console.WriteLine("Waiting from server...");
                s1.Connect(ipEP);
                String dataSend = "Hello, Server!<End>";
                byte[] byteSend = Encoding.ASCII.GetBytes(dataSend);
                s1.Send(byteSend);
                byte[] byteRec = new byte[size];
                int lenBytesRec = s1.Receive(byteRec);
                String dataRec = null;
                dataRec = Encoding.ASCII.GetString(byteRec);
                Console.WriteLine(dataRec);
                s1.Shutdown(SocketShutdown.Both);
                s1.Close();
                
            }
            catch(Exception exception)
            {
                Console.WriteLine(exception);
            }
            finally
            {
                Console.ReadLine();
            }

        }

        private static void SecondTask(int port, int size, int lenght)
        {
            try
            {
                Socket s1 = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                IPEndPoint ipEP = new IPEndPoint(IPAddress.Parse("0.0.0.0"), port);
                s1.Bind(ipEP);
                s1.Listen(lenght);
                while (true)
                {
                    Console.WriteLine("Waiting from server...");
                    Socket s2 = s1.Accept();
                    String dataRec = null;
                    while (true)
                    {
                        byte[] byteRec = new byte[size];
                        int lenBytesRec = s2.Receive(byteRec);
                        dataRec += Encoding.ASCII.GetString(byteRec, 0, lenBytesRec);
                        if(dataRec.IndexOf("<End>", StringComparison.Ordinal) > -1){
                            break;
                        }
                    }
                    Console.WriteLine(dataRec);
                    String dataSend = "Hello, client!<End>";
                    byte[] byteSend = Encoding.ASCII.GetBytes(dataSend);
                    int lenBytesSend = s2.Send(byteSend);
                    Console.WriteLine(lenBytesSend);
                    s2.Shutdown(SocketShutdown.Both);
                    s2.Close();
                }
            }
            catch(Exception exception)
            {
                Console.WriteLine(exception);
            }
        }


    }
}
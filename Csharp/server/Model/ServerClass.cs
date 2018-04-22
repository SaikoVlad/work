using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace server.Model
{
    public class ServerClass
    {
        TcpListener _listener; 
 
        public ServerClass(int port)
        {
            _listener = new TcpListener(IPAddress.Any, port);
            _listener.Start(); // Запускаем его
             
            while (true)
            {

                ThreadPool.QueueUserWorkItem(new WaitCallback(ClientThread), _listener.AcceptTcpClient());
//                new Client(_listener.AcceptTcpClient());
//                _listener.AcceptTcpClient();
            }
        }
        
        static void ClientThread(Object stateinfo)
        {
            new Client((TcpClient) stateinfo);
        }
 
        ~ServerClass()
        {
            
            if (_listener != null)
            {
                _listener.Stop();
            }
        }
    }
}
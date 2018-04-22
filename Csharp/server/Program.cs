using System;
using System.Threading;
using server.Model;

namespace server
{
    class Program
    {
        static void Main(string[] args)
        {
            int maxTreads = Environment.ProcessorCount * 4;
            ThreadPool.SetMaxThreads(maxTreads, maxTreads);
            ThreadPool.SetMinThreads(2, 2);
            
            
            new ServerClass(85);
        }
    }
}

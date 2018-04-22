using System;
using System.Threading;

namespace ConsoleApplication1
{
    public class Program
    {
        public static void Main(string[] args)
        {
            myThread t1 = new myThread("Поток 1", 6);
            myThread t2 = new myThread("Поток 2", 3);
            myThread t3 = new myThread("Поток 3", 2);
            

        }
        
    }

    class Father
    {
        public string NameMaker()
        {
            var name = "";
            Random random = new Random();
            var alphabet = "zxcvbnmasdfghjklqwertyuiop".ToCharArray();
            for (int j = 0; j < 10; j++)
            {
                name += alphabet[random.Next(alphabet.Length)];
            }
            return name;
        }
    }
    
    class myThread : Father
    {
        Thread thread;
        
        public myThread(string name, int num)
        {
            Console.WriteLine("fon");
            this.thread = new Thread(this.func);
            thread.Name = name;
            thread.Start(num);
        }

        void func(object num)
        {
            for (int i = 0;i < (int)num;i++ ) 
            {
                Console.WriteLine(Thread.CurrentThread.Name + " выводит " + i);
                Thread.Sleep(100);
            }
            Console.WriteLine(Thread.CurrentThread.Name + " завершился");
        }
    }
    
}

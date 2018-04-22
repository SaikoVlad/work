using System;
using System.Collections.Generic;
using System.Threading;
using System.Security.Cryptography;

namespace StoneScissorsPaper
{
    class Program
    {
       
        public static void Main(string[] args)
        {
            //Menu(args[0]);
            
            Console.WriteLine(PcResult());


        }

        private static readonly Dictionary<int, string> db = new Dictionary<int, string>();

        private static void FillDb()
        {
            db.Add(1,"Stone");
            db.Add(2,"Ножницы");
            db.Add(3,"Бумага");
            db.Add(4,"Ящерица");
            db.Add(5,"Спок");
        }

        private static int PcResult()
        {
            char[] ad = new char[3]{'7','7','7'};
            RNGCryptoServiceProvider a = new RNGCryptoServiceProvider();
            byte[] mas = new byte[1];
            while (ad[1] > 5 && ad[1] < 1)
            {
                a.GetBytes(mas);
                ad = mas[0].ToString().ToCharArray();
            }
            return ad[1];
        }

        private static int UserResult(string arg) // throws Exception
        {
            int user;
            try
            {
                user = Int32.Parse(arg);
            }
            catch (Exception)
            {
                throw new Exception("Не число!");
            }
            if (user < 1 || user > 5)
            {
                throw new Exception("Число должно быть от 1 до 5!");
            }
            return user;
        }
        
        private static string Compare(int user, int pc)
        {
            string result = String.Empty;
            string userRes = db[user];
            string pcRes = db[pc];
            switch (userRes)
            {
               case "Камень":
                   if (pcRes == "Спок" || pcRes == "Бумага")
                   {
                       result = "Проигрыш";
                   }else if (pcRes == userRes)
                   {
                       result = "Ничья";
                   }
                   else
                   {
                       result = "Победа";
                   }
                   break;
               case "Ножницы":
                   if (pcRes == "Спок" || pcRes == "Камень")
                   {
                       result = "Проигрыш";
                   }else if (pcRes == userRes)
                   {
                       result = "Ничья";
                   }
                   else
                   {
                       result = "Победа";
                   }
                   break;
               case "Бумага":
                   if (pcRes == "Ящерица" || pcRes == "Ножницы")
                   {
                       result = "Проигрыш";
                   }else if (pcRes == userRes)
                   {
                       result = "Ничья";
                   }
                   else
                   {
                       result = "Победа";
                   }
                   break;
               case "Ящерица":
                   if (pcRes == "Ножницы" || pcRes == "Камень")
                   {
                       result = "Проигрыш";
                   }else if (pcRes == userRes)
                   {
                       result = "Ничья";
                   }
                   else
                   {
                       result = "Победа";
                   }
                   break;
               case "Спок":
                   if (pcRes == "Ящерица" || pcRes == "Бумага")
                   {
                       result = "Проигрыш";
                   }else if (pcRes == userRes)
                   {
                       result = "Ничья";
                   }
                   else
                   {
                       result = "Победа";
                   }
                   break;
            }
            return result;
        }

        private static void Pause()
        {
            Console.WriteLine("Камень...");
            Thread.Sleep(300);
            Console.WriteLine("Ножницы...");
            Thread.Sleep(300);
            Console.WriteLine("Бумага...");
            Thread.Sleep(300);
            Console.WriteLine("Ящерица...");
            Thread.Sleep(300);
            Console.WriteLine("Спок...");
            Thread.Sleep(300);
            
        }

        private static void Menu(string arg)
        {
            FillDb();
            Pause();
            try
            {
                int pc = PcResult();
                int user = UserResult(arg);
                Console.WriteLine(Compare(user, pc));
                Console.WriteLine("Ваш выбор: " + db[user] + "\nМой выбор: " + db[pc]);
                Console.WriteLine("Ваш хеш код: {0}",db[user].GetHashCode());
                Console.WriteLine("Мой хеш код: {0}",db[pc].GetHashCode());
            
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                
            }
            
        }
        
    }
}
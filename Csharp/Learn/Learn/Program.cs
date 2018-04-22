using System;
using System.Collections.Generic;
namespace Learn
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Nasled n = new Nasled("Name","Surname");

            bool a = true;
            while (a)
            {
                Console.WriteLine("1 - set name\n2 - set surname\n3 - get name\n4 - get surname");
                int i = int.Parse(Console.ReadLine());
                switch (i)
                {
                    case 1:
                        Console.Write("What name?->");
                        string input = (Console.ReadLine());
                        n.SetName(input);
                        break;
                    case 2:
                        Console.Write("What surname?->");
                        input = (Console.ReadLine());
                        n.SetSurName(input);
                        break;
                    case 3:
                        Console.WriteLine(n.GetName());
                        break;
                    case 4:
                        Console.WriteLine(n.GetSurName());
                        break;
                    case 5:
                        Console.Clear();
                        break;
                    default:
                        a = false;
                        break;
                }

            }

        }
    }

    class GrandFather 
    {
        protected static string inc (string a)
        {
            return a.PadRight(3);
        }
    }

    class Father : GrandFather
    {
        protected static string toupper(string inString)
        {
            Console.WriteLine(inc(inString));
            return inString.ToUpper();
        }
    }

    class Nasled : Father
    {   
        
        private string name, surname;
        public Nasled(string n, string s)
        {
            this.name = toupper(n);
            this.surname = toupper(s);
        }
        public  string GetName()
        {
            return name;
        }
        public  string GetSurName()
        {
            return surname;
        }
        public  void SetName(string newName)
        {
            this.name = newName;
        }
        public  void SetSurName(string newSurname)
        {
            this.surname = newSurname;
        }
        



    }
}

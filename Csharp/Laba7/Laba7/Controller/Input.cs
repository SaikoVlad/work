using System;
using View;
namespace Controller
{
    public class Input
    {

        public static int Integer()
        {
            int outer;
            try
            {
                outer = int.Parse(Console.ReadLine());
            }catch (Exception )
            {
                Output.WriteLine("Incorrect input, sample choise = 9!!!");
                outer = 9;
            }
            return outer;
        }
        public static string String()
        {
            string outer = Console.ReadLine();
            return outer;
        }

    }
}


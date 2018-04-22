using System;
using Taskcsharp.Model;
using Taskcsharp.View;


namespace Taskcsharp
{
    internal class MainClass
    {
        public static void Main(string[] args)
        {
            Menu();
        }
        
        private static void Menu(){

            String choice;
            Initializer vector = new Initializer(new double[]{4.23, -5.43, 6.56, 4.23, -8.67, 4.45, 7.9});
            Output.Write(vector.ToString());
            bool ok = true;
            while (ok) {
                Output.Write("\n1 - Sum all negative elements\n2 - Multiply all elements between min and max\n->");
                choice = Console.ReadLine();
                switch (choice) {
                    case "1":
                        try {
                            Output.WriteLine("" + Operations.CalcSumOfNegativeElements(vector));
                        } catch (Exception e) {
                            Output.WriteLine("Vector is empty!!!");
                        }
                        break;
                    case "2":
                        try {
                            Output.WriteLine("" + Operations.CalcMultiplicationElementsBetweenMaxAndMin(vector));
                        } catch (Exception e) {
                            Output.WriteLine("Vector is empty!!!");
                        }
                        break;
                    default:
                        ok = false;
                        return;

                }
            }
        }
        
    }
}
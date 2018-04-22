using System;
using Model;
using View;
namespace Controller
{
    public class Menu
    {
        public static void menuForA()
        { //A9
            Output.WriteLine("Hello,this is the program for making matrix");
            int rows = Treatment.LimitInput("Please, input rows: ");
            int columns = Treatment.LimitInput("Please, input columns: ");
            Init massive = new Init(rows, columns);
            int [,]matrix = null;
            bool okay = true;

            while(okay)
            {
                Output.Write("\n1 - Random maker for matrix\n2 - Your own matrix\n3 - Show matrix\n4 - Find max element\n5 - Find min element\n6 - Sort columns by first element\n7 - Change rows and columns value\nDefault key to exit\n->");
                String choise = Input.String();
                switch (choise) 
                {
                    case "1":
                        matrix = massive.RandomMaker(rows, columns);
                        break;
                    case "2":
                        matrix = Treatment.matrixInput(rows,columns);
                        break;
                    case "3":
                        if (matrix == null)
                        {
                            Output.WriteLine("Massive equals null");
                        } 
                        else
                        {
                            Output.WriteMass(rows, columns, matrix);
                        }
                        break;
                    case "4":
                        if (matrix == null)
                        {
                            Output.WriteLine("Matrix equals null");
                        }
                        else
                        {
                            Output.WriteLine("Max value is " + Calculating.MaxFinder(rows, columns, matrix));
                            Output.WriteLine("Single: " + Verification.CheckForUnique(matrix, rows, columns, Calculating.MaxFinder(rows, columns, matrix)));
                        }
                        break;
                    case "5":
                        if (matrix == null)
                        {
                            Output.WriteLine("Matrix equals null");
                        }
                        else
                        {
                            Output.WriteLine("Min value is " + Calculating.MinFinder(rows, columns, matrix));
                            Output.WriteLine("Single: " + Verification.CheckForUnique(matrix, rows, columns, Calculating.MinFinder(rows, columns, matrix)));
                        }
                        break;
                    case "6":
                        sortionMenu(rows, columns, matrix);
                        break;
                    case "7":
                        rows = Treatment.LimitInput("Please, input rows: ");
                        columns = Treatment.LimitInput("Please, input columns: ");
                        matrix = null;
                        break;
                    default:
                        Output.WriteLine("Good bye");
                        okay = false;
                        break;
                }
            }
        }

        private static void sortionMenu(int rows, int columns, int [,] matrix)
        {
            if (matrix == null)
            {
                Output.WriteLine("Massive is empty");
            }
            else
            {
                Output.WriteLine("Set param for sorting: \n1 - From min to max\n2 - From max to min");
                int choise = Input.Integer();
                Output.WriteMass(rows,columns,Calculating.Sort(rows,columns,matrix,choise));
            }

        }
    }
}


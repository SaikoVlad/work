package by.bntu.fitr.povt.controller;

import by.bntu.fitr.povt.model.Calculating;
import by.bntu.fitr.povt.model.Init;
import by.bntu.fitr.povt.model.Verification;
import by.bntu.fitr.povt.view.Output;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    
    
    public static void menuForA(){ //A9
        Output.printLine("Hello,this is the program for making matrix");
        int rows = Treatment.checkInput("Rows: ");
        int columns = Treatment.limitInput("Please, input columns: ");
        Init massive = new Init(rows, columns);
        int matrix[][] = null;
        boolean okay = true;
        while(okay) {
            Output.print("\n1 - Random maker for matrix\n2 - Your own matrix\n3 - Show matrix\n4 - Find max element\n5 - Find min element\n6 - Sort columns by first element\n7 - Change rows and columns value\nDefault key to exit\n->");
            String choise = scanner.next();
            switch (choise) {
                case "1":
                    int maxRandom = Treatment.limitInput("Please, input max value for random: ");
                    matrix = massive.randomMaker(rows, columns,maxRandom);
                    break;
                case "2":
                    matrix = Treatment.matrixInput(rows,columns);
                    break;
                case "3":
                    if (matrix == null) {
                        Output.printLine("Massive equals null");
                    } else {
                        Output.printMass(rows, columns, matrix);
                    }
                    break;
                case "4":
                    if (matrix == null){
                        Output.printLine("Matrix equals null");
                    }else{
                        Output.printLine("Max value is " + Calculating.maxFinder(rows, columns, matrix));
                        Output.printLine("Single: " + Verification.checkForUnique(matrix, rows, columns, Calculating.maxFinder(rows, columns, matrix)));
                    }
                    break;
                case "5":
                    if (matrix == null){
                        Output.printLine("Matrix equals null");
                    }else {
                        Output.printLine("Min value is " + Calculating.minFinder(rows, columns, matrix));
                        Output.printLine("Single: " + Verification.checkForUnique(matrix, rows, columns, Calculating.minFinder(rows, columns, matrix)));
                    }
                    break;
                case "6":
                    sortionMenu(rows, columns, matrix);
                    break;
                case "7":
                    rows = Treatment.limitInput("Please, input rows: ");
                    columns = Treatment.limitInput("Please, input columns: ");
                    matrix = null;
                    break;
                default:
                    Output.printLine("Good bye");
                    okay = false;
                    break;
            }
        }
    }

    private static void sortionMenu(int rows, int columns, int [][] matrix){
        if (matrix == null){
            Output.printLine("Massive is empty");
        }else{
            Output.printLine("Set param for sorting: \n1 - From min to max\n2 - From max to min");
            int choise = Treatment.checkInt();
            Output.printMass(rows,columns,Calculating.sort(rows,columns,matrix,choise));
        }

    }



}

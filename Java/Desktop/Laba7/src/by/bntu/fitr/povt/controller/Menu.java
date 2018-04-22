package by.bntu.fitr.povt.controller;

import by.bntu.fitr.povt.model.Calculating;
import by.bntu.fitr.povt.model.Matrix;
import by.bntu.fitr.povt.model.Verification;
import by.bntu.fitr.povt.util.Input;
import by.bntu.fitr.povt.view.Output;
import java.util.Scanner;

public class Menu {

    public static void simpleMenu() {
        int rows = 5;
        int columns = rows;
        Matrix matrix = new Matrix(rows, columns, Input.randomMaker(rows, columns, 100));
        try {
            Output.printLine("\n\n" + matrix.toString() + "\n\n");
        } catch (NullPointerException e) {
            Output.printLine("Your matrix is empty");
        }
        try {
            Output.printLine("Max value is " + Calculating.maxFinder(rows, columns, matrix.getMatrix()));
            Output.printLine("Single: " + Verification.checkForUnique(matrix.getMatrix(), rows, columns, Calculating.maxFinder(rows, columns, matrix.getMatrix())));
        } catch (NullPointerException e) {
            Output.printLine("Your matrix is empty");
        }

        Output.printLine("\n\nMin value is " + Calculating.minFinder(rows, columns, matrix.getMatrix()));
        Output.printLine("Single: " + Verification.checkForUnique(matrix.getMatrix(), rows, columns, Calculating.minFinder(rows, columns, matrix.getMatrix())));


        Output.printLine("\n\nMax value is " + Calculating.maxFinder(rows, columns, matrix.getMatrix()));
        Output.printLine("Single: " + Verification.checkForUnique(matrix.getMatrix(), rows, columns, Calculating.maxFinder(rows, columns, matrix.getMatrix())));

        Output.printLine("\n");
        sortionMenu(rows,columns,matrix.getMatrix());


    }

    public static void menuForA() {
        Scanner scanner = new Scanner(System.in);
        Output.print("input rows:");
        int rows = Input.integer();
        Output.print("input columns:");
        int columns = Input.integer();
        Matrix matrix;
        Output.printLine("You need to create matrix. Choose one: \n1 - Random\n2 - Your own matrix");
        String choice = new Scanner(System.in).next();
        switch (choice) {
            case "1":
                Output.print("Input max value for random: ");
                int max = Input.integer();
                matrix = new Matrix(rows, columns, Input.randomMaker(rows, columns, max));
                break;
            case "2":
                matrix = new Matrix(rows, columns, Input.matrixInput(rows, columns));
                break;
            default:
                Output.printLine("Wrong choice. Matrix will be accidentally created");
                matrix = new Matrix(rows, columns, Input.randomMaker(rows, columns, 5));
        }

        boolean okay = true;
        while (okay) {
            Output.print("\n1 - Random maker for matrix\n2 - Your own matrix\n3 - Show matrix\n4 - Find max element\n5 - Find min element\n6 - Sort columns by first element\n7 - Change rows and columns value\n8 - Clear console\n9 - Delete matrix\nDefault key to exit\n->");
            choice = scanner.next();
            switch (choice) {
                case "1":
                    Output.print("Input max value for random: ");
                    int max = Input.integer();
                    try {
                        matrix = new Matrix(rows, columns, Input.randomMaker(rows, columns, max));
                    } catch (NullPointerException e) {
                        Output.printLine("NullPointerException");
                    }
                    break;
                case "2":
                    matrix = new Matrix(rows, columns, Input.matrixInput(rows, columns));
                    break;
                case "3":
                    try {
                        Output.printLine(matrix.toString());
                    } catch (NullPointerException e) {
                        Output.printLine("Your matrix is empty");
                    }
                    break;
                case "4":
                    try {
                        Output.printLine("Max value is " + Calculating.maxFinder(rows, columns, matrix.getMatrix()));
                        Output.printLine("Single: " + Verification.checkForUnique(matrix.getMatrix(), rows, columns, Calculating.maxFinder(rows, columns, matrix.getMatrix())));
                    } catch (NullPointerException e) {
                        Output.printLine("Your matrix is empty");
                    }
                    break;
                case "5":
                    if (matrix == null) {
                        Output.printLine("Matrix equals null");
                    } else {
                        Output.printLine("Min value is " + Calculating.minFinder(rows, columns, matrix.getMatrix()));
                        Output.printLine("Single: " + Verification.checkForUnique(matrix.getMatrix(), rows, columns, Calculating.minFinder(rows, columns, matrix.getMatrix())));
                    }
                    break;
                case "6":
                    try {
                        sortionMenu(rows, columns, matrix.getMatrix());
                    }catch (NullPointerException e){
                        Output.printLine("Matrix is empty");
                    }
                    break;
                case "7":
                    Output.print("input rows:");
                    rows = Input.integer();
                    Output.print("input columns:");
                    columns = Input.integer();
                    matrix = null;
                    break;
                case "8":
                    Output.consoleClear();
                    break;
                case "9":
                    matrix = null;
                    Output.printLine("Your matrix has been deleted");
                    Output.print("input rows:");
                    rows = Input.integer();
                    Output.print("input columns:");
                    columns = Input.integer();
                    break;
                default:
                    Output.printLine("Good bye");
                    okay = false;
                    break;
            }
        }
    }

    private static void sortionMenu(int rows, int columns, int[][] matrix) {

        try{
            Output.printLine("Set param for sorting: \n1 - From min to max\n2 - From max to min");
            int choice = Input.integer();
            Output.printMass(rows, columns, Calculating.sort(rows, columns, matrix, choice));
        }catch (NullPointerException e){
            Output.printLine("Massive is empty");
        }
//
//
//
//        if (matrix == null) {
//            Output.printLine("Massive is empty");
//        } else {
//            Output.printLine("Set param for sorting: \n1 - From min to max\n2 - From max to min");
//            int choice = Input.integer();
//            Output.printMass(rows, columns, Calculating.sort(rows, columns, matrix, choice));
//        }

    }

}

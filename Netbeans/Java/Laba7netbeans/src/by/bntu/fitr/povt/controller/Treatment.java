package by.bntu.fitr.povt.controller;

import by.bntu.fitr.povt.view.Output;

import java.util.Scanner;

public class Treatment {
    static Scanner scanner = new Scanner(System.in);
    
        public static int checkInt(){
        int a;
        try{
            a = scanner.nextInt();
        }catch (Exception e){
            Output.printLine(" " + e);
            a = 9;
        }
        return a;
    }
        
        public static int inputInt(String msg) {
//        Scanner scanner = new Scanner(System.in);
        Output.printLine(msg);
        int a = scanner.nextInt();
        return a;
    }

    public static int checkInput(String msg) {
        int a;

        while (true) {
            try {
                a = inputInt(msg);
                break;
            }
            catch (Exception e){
                Output.printLine("" + e + "\n");
            }
        }

        return a;
    }

    public static int limitInput(String str){
        Output.print(str);
        int rowsOrCols = checkInt();
        return rowsOrCols;
    }


    public static int[][]matrixInput(int rows,int columns){
        int matrix[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Output.print("Input element for " + (i + 1) + " row and " + (j + 1) + " column: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
}

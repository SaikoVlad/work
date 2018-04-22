package com.example.prostrmk.firstapp.by.bntu.fitr.povt.util;


import java.util.Random;
import java.util.Scanner;

public class Input {
//    public static int[][]matrixInput(int rows,int columns){
//        Scanner scanner = new Scanner(System.in);
//        int matrix[][] = new int[rows][columns];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                Output.print("Input element for " + (i + 1) + " row and " + (j + 1) + " column: ");
//                matrix[i][j] = anyInteger();
//            }
//        }
//        return matrix;
//    }


    public static int [][]randomMaker(int rows, int columns, int max){
        int [][]matrix = new int[rows][columns];
        Random random = new Random();
        for(int i = 0;i<rows;i++){
            for (int j = 0 ;j<columns;j++){
                matrix[i][j] = random.nextInt(max);
            }
        }
        return matrix;
    }

    public static int integer(){
        int out = 0;
        while (out <= 0) {
            try {
                out = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.err.println("Wrong number!!!Please, type correctly!");
            }
        }
        return out;
    }

    private static int anyInteger(){
        int out = -999999999;
        while (out == -999999999) {
            try {
                out = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.err.println("Wrong number!!!Please, type correctly!");
            }
        }
        return out;
    }

}

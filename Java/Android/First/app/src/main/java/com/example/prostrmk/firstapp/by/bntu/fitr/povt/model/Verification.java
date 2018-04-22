package com.example.prostrmk.firstapp.by.bntu.fitr.povt.model;

public class Verification {
    public static boolean checkForUnique(int [][]matrix,int rows,int columns, int feature){
        int count = 0;
        for (int i = 0;i < rows; i++){
            for (int j = 0;j < columns;j++){
                if (feature == matrix[i][j]){
                    count++;
                }
            }
        }
        if (count == 1){
            return true;
        }else{
            return false;
        }

    }
}

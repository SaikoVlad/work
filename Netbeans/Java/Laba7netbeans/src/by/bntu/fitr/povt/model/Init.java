package by.bntu.fitr.povt.model;

import java.util.Random;


public class Init {
    private int rows,columns;
    private int matrix[][];

    public Init(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
        
    }



    public int [][]randomMaker(int rows, int columns, int max){
        //int [][]matrix = new int[rows][columns];
        Random random = new Random();
        for(int i = 0;i<rows;i++){
            for (int j = 0 ;j<columns;j++){
                matrix[i][j] = random.nextInt(max);
            }
        }

        return matrix;
    }

}

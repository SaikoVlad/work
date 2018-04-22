package com.example.prostrmk.firstapp.by.bntu.fitr.povt.model;


public class Matrix {
    private int rows,columns;
    private int matrix[][];

    public Matrix(int rows, int columns, int matrix[][]) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getMatrix(){
        return this.matrix;
    }

    @Override
    public String toString() {
        String out = "";
        for(int i = 0;i<rows;i++){
            for (int j = 0 ;j<columns;j++){
                out += "\t" + matrix[i][j];
            }
            out += "\n\n";
        }
        return out;
    }




}

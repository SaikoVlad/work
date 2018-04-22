using System;
using View;
namespace Controller
{
    public class Treatment
    {
        

        public static int LimitInput(String str){
            Output.WriteLine(str);
            int rowsOrCols = Input.Integer();
            return rowsOrCols;
        }


        public static int[,]matrixInput(int rows,int columns){
            int [,]matrix = new int[rows,columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    Output.Write("Input element for " + (i + 1) + " row and " + (j + 1) + " column: ");
                    matrix[i,j] = Input.Integer();
                }
            }
            return matrix;
        }
    }
}


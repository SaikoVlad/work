using System;

namespace Model
{
    public class Init
    {
        private int rows,columns;
        private int [,]matrix;

        public Init(int rows, int columns)
        {
            this.rows = rows;
            this.columns = columns;
            this.matrix = new int[rows, columns];
        }

        public int [,] RandomMaker(int rows, int columns)
        {
            int [,]matrix = new int[rows, columns];
            Random random = new Random();
            for(int i = 0;i<rows;i++)
            {
                for (int j = 0 ;j<columns;j++)
                {
                    matrix[i,j] = random.Next(100);
                }
            }

            return matrix;
        }
    }
}


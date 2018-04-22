package by.bntu.fitr.povt.model;



public class MinSeries {
    public static int check(){
        final int rows = 3, columns = 3;
        int massive[][] = new int[rows][columns];
        int count = 0;
        int sum = 0;
        for(int i = 0;i < rows;i++)
        {
            for(int j = 0;j < 3;j++)
            {
                if( i >= j)
                {
                    count++;
                    sum+= massive[i][j];
                }
            }
        }

        return sum;
    }
}

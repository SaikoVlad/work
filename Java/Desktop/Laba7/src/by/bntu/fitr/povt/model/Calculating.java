package by.bntu.fitr.povt.model;

public class Calculating {
    public static int minFinder(int rows, int columns, int matrix[][]) {

        int min = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    public static int maxFinder(int rows, int columns, int matrix[][]) {

        int max = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    ///////////////////////////////////////////////////////////B point
    public static int[][] sort(int rows, int columns, int[][] massive, int fromMin) {
        int temp;
        if (fromMin > 0) {
            for (int i = 0; i < rows; i++) {
                for (int k = i + 1; k < rows; k++) {
                    if (fromMin == 1) {
                        if (massive[0][i] > massive[0][k]) {
                            for (int j = 0; j < columns; j++) {
                                temp = massive[j][i];
                                massive[j][i] = massive[j][k];
                                massive[j][k] = temp;
                            }
                        }
                    }else{
                        if (massive[0][i] < massive[0][k]) {
                            for (int j = 0; j < columns; j++) {
                                temp = massive[j][i];
                                massive[j][i] = massive[j][k];
                                massive[j][k] = temp;
                            }
                        }
                    }
                }
            }
        }
        return massive;
    }

}

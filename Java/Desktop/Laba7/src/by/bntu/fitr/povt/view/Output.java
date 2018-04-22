package by.bntu.fitr.povt.view;

public class Output {

    private int rows,columns;
    private int matrix[][] = new int[rows][columns];
    public Output(int rows, int columns, int[][] matrix) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
    }
    public static void print(String out){
        System.out.print(out);
    }
    public static void printLine(String out){
        System.out.println(out);
    }
    public static void printMass(int rows, int columns, int[][] matrix) {
        String out = "";
        for(int i = 0;i<rows;i++){
            for (int j = 0 ;j<columns;j++){
                out += "\t" + matrix[i][j];
            }
            out += "\n\n";
        }
        Output.printLine(out);
    }
    public static void consoleClear(){
        Output.printLine("\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}

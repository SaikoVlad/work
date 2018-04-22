package view;

import java.util.Scanner;

public class Read {

    static Scanner scanner = new Scanner(System.in);

    public static int Integer() {
        int input = scanner.nextInt();
        return input;
    }
    public static String String() {
        String input = scanner.next();
        return input;
    }
    public static double Double() {
        double input = scanner.nextDouble();
        return input;
    }
    public static boolean Boolean() {
        boolean input = scanner.nextBoolean();
        return input;
    }
    
    
}

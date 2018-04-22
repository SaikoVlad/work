package model;

public class SimpleOrNot {
    
    public static boolean simpleOrNot(int n) {
        boolean f = true;
        int i;
        for (i = 2; i < n; i++) {
            if (n % i == 0) {
                f = false;
                break;
            }
        }
        if (f) {
            return true;
        } else {
            return false;
        }
    }
    
}

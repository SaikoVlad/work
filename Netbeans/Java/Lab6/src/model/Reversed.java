package model;

public class Reversed {
    
    public static int reverser(int digit) {
        int res = 0;
        while (true) {
            if (digit > 0) {
                res = digit % 10 + res * 10;
                digit /= 10;
            } else {
                break;
            }
        }
        return res;
    }
    
}

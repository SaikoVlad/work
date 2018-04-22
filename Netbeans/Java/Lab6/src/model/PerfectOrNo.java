package model;

public class PerfectOrNo {

    public static boolean checkerForPerfection(int choose) {

            if (sum(choose)) {
                
                return true;
            } else {
                
                return false;
            }
        }
    
    private static boolean sum(int n) {
        int summa = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                summa += i;
            }
        }
        if (summa == n) {
            return true;
        } else {
            return false;
        }
    }
        
}
    
    



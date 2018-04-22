package FlowerShop.Controller;

public class MaksLoh {
    static boolean recursion(int n, int i) throws Exception {
        if (n < 0){
            throw new Exception("Incorrect number!");
        }
        if (n > 0 && n < 2) {
            return false;
        }
        else if (n == 2) {
            return true;
        }
        else if (n % i == 0) {
            return false;
        }
        else if (i < n / 2) {
            return recursion(n, i + 1);
        } else {
            return true;
        }
    }



}

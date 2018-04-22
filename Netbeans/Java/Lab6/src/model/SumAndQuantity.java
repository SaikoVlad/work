package model;

public class SumAndQuantity {
    public static int sum(int n) {

        int sum = 0, count = 0;
        while (n != 0) {
            sum = sum + (n % 10);
            n /= 10;
            count++;
        }
        return sum;
    }
    public static int quantity(int n){
        int count = 0;
        while (n!=0){
            n /= 10;
            count++;
        }
        
        return count;
    }
}

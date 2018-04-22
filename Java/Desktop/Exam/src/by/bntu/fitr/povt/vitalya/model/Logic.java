package by.bntu.fitr.povt.vitalya.model;

public class Logic {

    public static boolean even(int number) {
        if (number <= 0)
            return false;
        return pow(number, 0);
    }

    private static boolean pow(int number, int residue) {

        boolean result;

        if (residue == 1)
            result = false;
        else {
            residue = number % 2;
            number /= 2;
            result = pow(number, residue);
        }
        return result;
    }
}

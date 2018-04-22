package by.bntu.fitr.povt.model;

public class Data {

    public static String next(int a, int b, int c) {
        boolean vs = false;
        
        if ((a % 4 == 0 & a % 100 != 0 & a % 400 != 0) |
                (a % 4 == 0 & a % 100 == 0 & a % 400 == 0)) vs = true;
        if ((c == 31 & (((b % 2 != 0) & (b <= 7)) | ((b % 2 == 0) & (b > 7)))) |
                (c == 30 & (((b % 2 == 0) & (b < 7)) | ((b % 2 != 0) & (b > 8)))) |
                (c == 28 & vs == false) | (c == 29 & vs)) {
            c = 1;
            if (b < 12) b++;
            else {
                b = 1;
                a++;
            }
        } else c++;
        if (b > 12)
        {
            return "Неправильный ввод";
        }
        return a + "." + b + "." + c;
    }
}

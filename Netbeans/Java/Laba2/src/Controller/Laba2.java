package Controller;

import Model.Brosok;
import View.View;
import java.util.Scanner;

public class Laba2 {

    public static void main(String[] args) {
        
    }
    
    public static void DiceMenu(){
        Scanner in = new Scanner(System.in);
        String s;
        int you1, you2, ya1, ya2;

        View.printer("Привет, я виртуальная игра Dice! Давай сыграем!");
        while (true) {
            while (true) {
                View.printer("Выбери, кто кинет кости первым: введи 1, "
                        + "если хочешь кинуть первым, или 2, если хочешь, чтобы кинул я.");
                s = in.nextLine();
                if (s.equals("1")) {
                    View.printer("Ок, ты кидаешь первым.\nНажми Enter, чтобы кинуть кости.");
                    s = in.nextLine();
                    you1 = Brosok.brosok();
                    you2 = Brosok.brosok();
                    View.printer("Результат: " + you1 + " и " + you2
                            + " , а вместе - " + (you1 + you2) + ".");
                    View.printer("Теперь кидаю я. Нажми Enter, чтобы я кинул кости.");
                    s = in.nextLine();
                    ya1 = Brosok.brosok();
                    ya2 = Brosok.brosok();
                    View.printer("Результат: " + ya1 + " и " + ya2
                            + " , а вместе - " + (ya1 + ya2) + ".");
                    break;
                } else if (s.equals("2")) {
                    View.printer("Ок, я кидаю первым.\nНажми Enter, чтобы кинуть кости.");
                    s = in.nextLine();
                    ya1 = Brosok.brosok();
                    ya2 = Brosok.brosok();
                    View.printer("Результат: " + ya1 + " и " + ya2
                            + " , а вместе - " + (ya1 + ya2) + ".");
                    View.printer("Теперь кидаешь ты. Нажми Enter, чтобы кинуть кости.");
                    s = in.nextLine();
                    you1 = Brosok.brosok();
                    you2 = Brosok.brosok();
                    View.printer("Результат: " + you1 + " и " + you2
                            + " , а вместе - " + (you1 + you2) + ".");
                    break;
                } else {
                    View.printer("Нужно выбрать 1 или 2!!!");
                }
            }
            if (ya1 + ya2 > you1 + you2) {
                View.printer("Ха-ха, я победил!");
            } else if (you1 + you2 > ya1 + ya2) {
                View.printer("Ты победил!");
            } else {
                View.printer("Ничья!");
            }
            View.printer("Нажми Enter для повтора, или введи 0 для выхода.");
            s = in.nextLine();
            if (s.equals("0")) {
                break;
            }
        }
    }
}

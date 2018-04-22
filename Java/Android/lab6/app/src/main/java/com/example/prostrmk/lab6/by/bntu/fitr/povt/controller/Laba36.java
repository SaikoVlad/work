package com.example.prostrmk.lab6.by.bntu.fitr.povt.controller;


import android.widget.TextView;

import com.example.prostrmk.lab6.by.bntu.fitr.povt.model.Data;
import com.example.prostrmk.lab6.by.bntu.fitr.povt.model.Koren;
import com.example.prostrmk.lab6.by.bntu.fitr.povt.model.Nastroi;
import com.example.prostrmk.lab6.by.bntu.fitr.povt.model.Randomm;
import com.example.prostrmk.lab6.by.bntu.fitr.povt.model.UserInput;

import java.util.Random;

public class Laba36 {

    static TextView textView;

    public static void Menu() {

        Random random = new Random();




        boolean work = true;
        int choice, item;
        String again;

        //Output.print("Привет! Я многофункциональная программа.");
        while (work) {
            choice = UserInput.inputInt("\n\nВыбери что хочешь сделать:"
                    + "\n1 - посчитать головы и глаза у дракона;"
                    + "\n2 - узнать свое настроение;"
                    + "\n3 - сыграть со мной в кости;"
                    + "\n4 - проверить является ли буква согласной или гласной;"
                    + "\n5 - решить квадратное уравнение;"
                    + "\n6 - определить дату завтрашнего дня;"
                    + "\n0 - выход:\n");
            switch (choice) {
                case 1:
                    int ages = UserInput.inputInt("Привет!"
                            + " Я программа, которая высчитывает сколько"
                            + " голов и глаз у дракона, согласно его возрасту.\nВведи возраст дракона:\n");
//                    Output.print(Dragon.count(ages));
                    break;
                case 2:
                    //Output.print(Nastroi.nastroi(Randomm.nastroiRandom()));
                    break;
                case 3:
                    diceMain();
                    break;
                case 4:
                    glasSoglasMain();
                    break;
                case 5:
                    quadricEquationMain();
                    break;
                case 6:
                    dataMain();
                    break;
                case 0:
                    work = false;
                    break;
                default:
                    //Output.print("Некорректный ввод!");
                    break;
            }

        }
    }

    private static void diceMain() {
        String s;
        int you1, you2, ya1, ya2;

//        Output.print("Привет, я виртуальная игра Dice! Давай сыграем!");
        while (true) {
            s = UserInput.inputString("Выбери, кто кинет кости первым: введи 1, "
                    + "если хочешь кинуть первым, или 2, если хочешь, чтобы кинул я:\n");

            if (s.equals("1")) {
                s = UserInput.inputString("Ок, ты кидаешь первым.\nНажми Enter, чтобы кинуть кости.");

                you1 = Randomm.brosok();
                you2 = Randomm.brosok();
//                Output.print("Результат: " + you1 + " и " + you2
//                        + " , а вместе - " + (you1 + you2) + ".");

                s = UserInput.inputString("\nТеперь кидаю я.\nНажми Enter, чтобы я кинул кости.");

                ya1 = Randomm.brosok();
                ya2 = Randomm.brosok();
//                Output.print("Результат: " + ya1 + " и " + ya2
//                        + " , а вместе - " + (ya1 + ya2) + ".");

                break;
            } else if (s.equals("2")) {
                s = UserInput.inputString("Ок, я кидаю первым.\nНажми Enter, чтобы кинуть кости.");

                ya1 = Randomm.brosok();
                ya2 = Randomm.brosok();
//                Output.print("Результат: " + ya1 + " и " + ya2
//                        + " , а вместе - " + (ya1 + ya2) + ".");

                s = UserInput.inputString("Теперь кидаешь ты. Нажми Enter, чтобы кинуть кости.");

                you1 = Randomm.brosok();
                you2 = Randomm.brosok();
//                Output.print("Результат: " + you1 + " и " + you2
//                        + " , а вместе - " + (you1 + you2) + ".");

                break;
            } else {
//                Output.print("Нужно выбрать 1 или 2!!!");
            }
        }

        if (ya1 + ya2 > you1 + you2) {
//            Output.print("\nХа-ха, я победил!");
        } else if (you1 + you2 > ya1 + ya2) {
//            Output.print("\nТы победил!");
        } else {
//            Output.print("\nНичья!");
        }
    }

    private static void glasSoglasMain() {
        String bukvi, s;
        String glas = "ЁёУуЕеЫыАаОоЭэЯяИиЮю";
        String sogl = "БбВвГгДдЖжЗзЙйКкЛлМмНнПпРрСсТтФфХхЦцЧчШшЩщ";

        char[] glasAraay = glas.toCharArray();
        char[] soglAraay = sogl.toCharArray();

        bukvi = UserInput.inputString("Введи строку состоящую из гласных и согласных букв:");
        char[] bukviArray = bukvi.toCharArray();

        for (int i = 0; i < bukviArray.length; i++) {
            //Output.print(GlasSoglas.obrabotka(bukviArray[i], glasAraay, soglAraay) + "\n");
        }
    }

    private static void quadricEquationMain() {
        double a, b, c, d, x1, x2;

        //Output.print("Привет, я могу посчитать квадратное уравнение вида: ax^2+bx+c=0.\n");

        a = UserInput.inputInt("Введи a: ");
        b = UserInput.inputInt("Введи b: ");
        c = UserInput.inputInt("Введи c: ");

        if (a != 0) {
            d = b * b - 4 * a * c;

            if (d > 0) {
                x1 = Koren.root(a, b, d, 1);
                x2 = Koren.root(a, b, d, -1);

//                Output.print("\nСуществует два решения уравнения:");
//                Output.print("\nx1 = " + x1);
//                Output.print("\nx2 = " + x2);
            } else if (d == 0) {
                x1 = Koren.root(a, b, d, 1);

//                Output.print("\nСуществует два решения уравнения, но они совпадают:");
//                Output.print("\nx1 = x2 = " + x1);
            } else {
//                Output.print("\nРешений уравнения не существует!");
            }
        } else {
//            Output.print("\na не может равняться нулю!!!");
        }
    }

    private static void dataMain() {
//        Output.print("Привет, я могу определить дату следующего дня.\n");
        int a = UserInput.inputInt("\nВведи год:\n");
        int b = UserInput.inputInt("Введи месяц:\n");
        int c = UserInput.inputInt("Введи день:\n");
//        Output.print(DataWorks.next(a, b, c));
    }

}

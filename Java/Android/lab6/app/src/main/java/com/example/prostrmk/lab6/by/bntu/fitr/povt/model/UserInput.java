package com.example.prostrmk.lab6.by.bntu.fitr.povt.model;

import android.widget.TextView;

import java.util.Scanner;

public class UserInput {




    public static int inputInt(String msg) {
//        System.out.print(msg);

        return new Scanner(System.in).nextInt();
    }

    public static String inputString(String msg) {
        System.out.print(msg);
        return new Scanner(System.in).nextLine();
    }
}

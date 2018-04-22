package by.bntu.fitr.povt.vitalya.controller;

import by.bntu.fitr.povt.vitalya.model.Logic;
import by.bntu.fitr.povt.vitalya.view.View;

import java.util.Scanner;

public class Main {

    public static int i = 2;

    public static void main(String[] args) {

        for (int j = 0; j < 10; j++) {
            System.out.println(rec(j));
        }

    }

    private static boolean rec(int n){
        if (n < 0){
            return false;
        }else if(n == 1){
            return false;
        }else if (n == 2){
            return true;
        }else if (n % i == 0){
            return false;
        } else if (i < n / 2) {
            i++;
            return rec(n);
        }else{
            return true;
        }
    }
}

package com.example.prostrmk.lab6.by.bntu.fitr.povt.model;

public class Dragon {

    public static String count(int ages) {
        if(ages < 1) {
            return "Недопустимый возраст дракона!";
        }
        else if(ages < 201 && ages > 0) {
            return "Голов: " + ages*3 + ".\nГлаз: " + ages*6 +".";
        }
        else if(ages < 301 && ages > 200) {
            return "Голов: " + (200*3+(ages-200)*2) + ".\nГлаз: " + (200*6+(ages-200)*4) +".";
        }
        else {
            return "Голов: " + (200*3+100*2+(ages-300)) + ".\nГлаз: " + (200*6+100*4+(ages-300)*2) +".";
        }
    }
}

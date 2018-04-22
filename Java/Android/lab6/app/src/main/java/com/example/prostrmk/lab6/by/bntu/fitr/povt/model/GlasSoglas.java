package com.example.prostrmk.lab6.by.bntu.fitr.povt.model;

public class GlasSoglas {
    public static String obrabotka(char bukva, char[] glasArray, char[] soglArray) {
        for (int i = 0; i<glasArray.length; i++) {
            if (bukva == glasArray[i]) {
                return bukva + " - гласная";
            }
        }

        for (int i = 0; i<soglArray.length; i++) {
            if (bukva == soglArray[i]) {
                return bukva + " - согласная";
            }
        }

        return bukva + " - символ не является гласной или согласной буквой";
    }
}

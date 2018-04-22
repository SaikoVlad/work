package com.example.prostrmk.lab6.by.bntu.fitr.povt.model;

import java.util.Random;

public class Randomm {

    public static int brosok() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static int nastroiRandom() {
        Random random = new Random();
        return random.nextInt(5);
    }
}

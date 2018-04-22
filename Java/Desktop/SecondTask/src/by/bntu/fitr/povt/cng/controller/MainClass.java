package by.bntu.fitr.povt.cng.controller;

import by.bntu.fitr.povt.cng.model.entity.Vector;
import by.bntu.fitr.povt.cng.model.logic.Operations;
import by.bntu.fitr.povt.cng.view.Output;

import java.util.Scanner;

public class MainClass {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        newMenu();

    }



    private static void newMenu(){
        Vector vector = new Vector(4.4,2.2,8.8);
        Output.writeLine(vector + "\t - Vector");
        Output.writeLine(Operations.getMax(vector) + "\t\t\t\t - max value");
        Vector newVector = Operations.getNewVector(vector,Operations.getMax(vector));
        Output.writeLine(newVector + "\t - new vector");
    }

}

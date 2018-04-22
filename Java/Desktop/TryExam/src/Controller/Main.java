package Controller;

import Model.RecModel;
import View.Out;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {
            try{
                Out.print(i + " is simple: " + RecModel.recursion(i, 2));// второй параметр всегда должен быть два!
            } catch (Exception e) {
                Out.print(e);
            }
        }

    }

}

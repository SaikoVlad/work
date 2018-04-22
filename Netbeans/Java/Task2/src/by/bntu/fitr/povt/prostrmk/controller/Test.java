package by.bntu.fitr.povt.prostrmk.controller;

import by.bntu.fitr.povt.prostrmk.model.entity.SuperVector;
import by.bntu.fitr.povt.prostrmk.model.logic.VectorWorker;
import by.bntu.fitr.povt.prostrmk.view.Printer;

public class Test {

    public static void main(String[] args) {
        SuperVector vector
                = new SuperVector(2.1, -4.2, 6.3, -8.4, 3.0, 8.0, 10.6);

        double sum
                = VectorWorker.calcSumOfNegativeElements(vector);
        double mult
                = VectorWorker.calcMultiplicationElementsBetweenMaxAndMin(vector);

        Printer.print(vector + "");
        Printer.print(String.format("Sum = %.2f", sum));
        Printer.print(String.format("Mult = %.2f", mult));
    }
}

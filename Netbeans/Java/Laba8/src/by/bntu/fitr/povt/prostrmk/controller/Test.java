package by.bntu.fitr.povt.prostrmk.controller;

import by.bntu.fitr.povt.prostrmk.model.entity.Bread;
import by.bntu.fitr.povt.prostrmk.model.entity.Milk;
import by.bntu.fitr.povt.prostrmk.model.entity.Orange;
import by.bntu.fitr.povt.prostrmk.model.entity.Snickers;
import by.bntu.fitr.povt.prostrmk.model.entity.container.Basket;
import by.bntu.fitr.povt.prostrmk.model.logic.ShopAssistance;
import by.bntu.fitr.povt.prostrmk.view.Printer;

public class Test {

    public static void main(String[] args) {
        Orange o1 = new Orange(100, 2000, 2.50);
        Milk m1 = new Milk(1000, 3.5, 1.70);
        Bread b1 = new Bread("black", "first", 0.8);
        Bread b2 = new Bread("black", "first", 0.8);

        Snickers s1 = new Snickers(1.6);
        Snickers s2 = new Snickers(1.6);
        Snickers s3 = new Snickers(1.6);
        Snickers s4 = new Snickers(1.6);
        Snickers s5 = new Snickers(1.6);

        Basket basket = new Basket(5);
        basket.add(b2);
        basket.add(b1);
        basket.add(m1);
        basket.add(o1);
        basket.add(s1);
        basket.add(s2);
        basket.add(s3);
        basket.add(s4);
        basket.add(s5);

        Printer.print(basket + "");

        double total = ShopAssistance.calculateTotalPrice(basket);

        String s = String.format("Total price: %.2f", total);

        Printer.print(s);
    }
}

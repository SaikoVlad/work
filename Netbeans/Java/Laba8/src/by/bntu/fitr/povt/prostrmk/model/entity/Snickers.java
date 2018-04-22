/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.fitr.povt.prostrmk.model.entity;

/**
 *
 * @author VikVik
 */
public class Snickers {
    private double price;

    public Snickers() {
    }

    public Snickers(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Snickers{" + "price=" + price + '}';
    }
    
    
}

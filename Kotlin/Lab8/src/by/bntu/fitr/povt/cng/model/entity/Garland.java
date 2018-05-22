package by.bntu.fitr.povt.cng.model.entity;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

import java.io.Serializable;

public class Garland extends Toy implements Serializable {
    private double length;
    private int countOfElements;
    private String element;

    public Garland() {
    }

    public Garland(double price, double weight, double size, double length, int countOfElements, String element) {
        super(price, weight, size);
        this.length = length;
        this.countOfElements = countOfElements;
        this.element = element;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getCountOfElements() {
        return countOfElements;
    }

    public void setCountOfElements(int countOfElements) {
        this.countOfElements = countOfElements;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\nGarland ").append(super.toString()).append("\n\tLength: ").append(length).append("\n\tCount of elements: ").append(countOfElements).append("\n\tElement: ").append(element).toString();//length,countofelem,elem
    }

}

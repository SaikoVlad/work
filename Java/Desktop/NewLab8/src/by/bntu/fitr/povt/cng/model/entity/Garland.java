package by.bntu.fitr.povt.cng.model.entity;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

public class Garland extends Toy {
    private double length;
    private int countOfElemets;
    private String element;

    public Garland() {
    }

    public Garland(double price, double weight, double size, double length, int countOfElemets, String element) {
        super(price, weight, size);
        this.length = length;
        this.countOfElemets = countOfElemets;
        this.element = element;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getCountOfElemets() {
        return countOfElemets;
    }

    public void setCountOfElemets(int countOfElemets) {
        this.countOfElemets = countOfElemets;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\nGarland " + super.toString()).toString();// + "\n\tLength: " + length + "\n\tCount of elements: " + countOfElemets + "\n\tElement: " + element).toString();//length,countofelem,elem
    }

}

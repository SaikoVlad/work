package NewYearGift.Model.Entity;

import NewYearGift.Model.Entity.Abstract.Candy;

public class Lollipop extends Candy {

    private double diameter;
    private String taste;

    public Lollipop(double weight, String creator, double price, double diameter, String taste) {
        super(weight, creator, price);
        this.diameter = diameter;
        this.taste = taste;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString(){
        return new StringBuilder().append("Lollipop ").append(super.toString()).append("Diameter: ").append(diameter).append("\nTaste: ").append(taste).toString();
    }

}

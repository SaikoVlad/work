package by.bntu.fitr.povt.prostrmk.model.entity;

public class Orange {
    private double diameter;
    private double vitaminC;
    private double cost;

    public Orange() {
    }

    public Orange(double diameter, double vitaminC, double cost) {
        this.diameter = diameter;
        this.vitaminC = vitaminC;
        this.cost = cost;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(double vitaminC) {
        this.vitaminC = vitaminC;
    }

    public double getPrice() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Orange{" + "diameter=" + diameter + ", vitaminC=" + vitaminC + ", cost=" + cost + '}';
    }
    
}

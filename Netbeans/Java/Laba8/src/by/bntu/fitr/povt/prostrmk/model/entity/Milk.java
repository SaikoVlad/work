package by.bntu.fitr.povt.prostrmk.model.entity;

public class Milk {
    private double volume;
    private double fat;
    private double price;

    public Milk() {
    }

    public Milk(double volume, double fat, double price) {
        this.volume = volume;
        this.fat = fat;
        this.price = price;
    }
    
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Milk{" + "volume=" + volume + ", fat=" + fat + ", price=" + price + '}';
    }   
    
}

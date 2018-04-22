package FlowerShop.Model.Entity.Abstracts;

public class Flower {

    private double size;
    private double price;
    private String name;

    public Flower(double size, double price, String name) {
        this.size = size;
        this.price = price;
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Params:\nSize: %s\nPrice: %s\nName: %s",size,price,name);
    }
}

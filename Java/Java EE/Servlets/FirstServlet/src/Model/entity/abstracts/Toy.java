package Model.entity.abstracts;

public class Toy {
    private double price;
    private double weight;
    private double size;

    public Toy() {
    }

    public Toy(double price, double weight, double size) {
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Params:\n\tPrice: ").append(price).append("\n\tSize: ").append(size).append("\n\tWeight: ").append(weight).toString();//price,size,weight
    }
}

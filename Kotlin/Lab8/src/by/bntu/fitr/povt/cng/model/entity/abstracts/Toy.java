package by.bntu.fitr.povt.cng.model.entity.abstracts;


import java.io.Serializable;

public class Toy implements Comparable<Toy>, Serializable {
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
    public int hashCode() {
        final int HASHCONST = 31;
        int result = 1;
        result = HASHCONST * result + (int)price;
        result = HASHCONST * result + (int)weight;
        result = HASHCONST * result + (int)size;
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object.getClass() == this.getClass() && object.hashCode() == this.hashCode()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\n\tPrice: ").append(price).append("\n\tSize: ").append(size).append("\n\tWeight: ").append(weight).toString();//price,size,weight
    }

    @Override
    public int compareTo(Toy o) {
        return (int) (this.price - o.price);
    }
}

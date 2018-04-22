package NewYearGift.Model.Entity.Abstract;

public class Candy {

    private double weight;
    private String creator;
    private double price;


    public Candy(double weight, String creator, double price) {
        this.weight = weight;
        this.creator = creator;
        this.price = price;

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Parameters:\nWeight: ").append(weight).append("\nCreator: ").append(creator).append("\nPrice: ").append(price).append("\n").toString();
    }
}

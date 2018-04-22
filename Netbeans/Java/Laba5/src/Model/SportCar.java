package Model;

public class SportCar extends Cars{
    
    static double weight;
    static int price;
    static String brand;
    static double acceleration;

    public SportCar(double weight, int price, double acceleration, String brand) {
        this.weight = weight;
        this.price = price;
        this.brand = brand;
        this.acceleration = acceleration;
    }

    @Override
    public String writeInfo() {
        String params = "Type: " + getType();
        params += "\nWeight: " + Double.toString(weight) + " kg";
        params += "\nPrice:  " + Integer.toString(price) + " $";
        params += "\nMilage: " + Double.toString(acceleration) + "km";
        params += "\nBrand: " + brand;
        

        return params;
    }

    @Override
    public String getType() {
        return "Sport Car";
    }
    
}

package Model;

public class PassengerCar extends Cars {

    double weight;
    int price;
    String brand;
    double acceleration;

    public PassengerCar(double weight, int price, double acceleration, String brand) {
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
        params += "\nAcceleration: " + Double.toString(acceleration) + "seconds";
        params += "\nBrand: " + brand;
        

        return params;
    }

    @Override
    public String getType() {
        return "Passanger Car";
    }
    
    public int getPrice(){
        return price;
    }
    
    
    

}

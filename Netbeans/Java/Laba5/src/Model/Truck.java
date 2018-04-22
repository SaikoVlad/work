package Model;

public class Truck extends Cars{
    
    static double weight;
    static int price;
    static String brand;
    static int engineCapacity;

    public Truck(double weight, int price,int engineCapacity, String brand) {
        this.weight = weight;
        this.price = price;
        this.brand = brand;
        this.engineCapacity = engineCapacity;
    }
    
    @Override
    public String writeInfo(){
        String params = "Type: " + getType();
        params += "\nWeight: " + Double.toString(weight) + " kg";
        params += "\nPrice:  " + Integer.toString(price) + " $";
        params += "\nEngine Capacity: " + Integer.toString(engineCapacity)+ " liters";
        params += "\nBrand: " + brand; 
        
        
        return params;
    }
    
    @Override
    public String getType(){
        return "Truck";
    }
    
}

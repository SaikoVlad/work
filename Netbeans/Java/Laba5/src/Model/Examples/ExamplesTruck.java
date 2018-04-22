package Model.Examples;

import Model.Truck;
import java.util.Random;

public class ExamplesTruck {
    public static Truck exTruck(){
        Truck FordF_150 = new Truck(4000, 30000, 365, "Ford F-150");
        Truck GMCCanyon = new Truck(3300, 34134, 400, "GMC Canyon");
        Truck ChevroletSilverado2500HD = new Truck(3600, 35600, 380, "Chevrolet Silverado 2500HD");
        Random random = new Random();
        int i = random.nextInt(3) + 1;
        switch (i) {
            case 1:
                return FordF_150;
            case 2:
                return GMCCanyon;
            case 3:
                return ChevroletSilverado2500HD;
            default:
                return GMCCanyon;
        }
    }
    
}

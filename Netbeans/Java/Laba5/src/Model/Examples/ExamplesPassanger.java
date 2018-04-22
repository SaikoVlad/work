package Model.Examples;

import Model.PassengerCar;
import java.util.Random;

public class ExamplesPassanger {

    public static PassengerCar sedan() {
        PassengerCar FordFiesta = new PassengerCar(1900, 19000, 11.4, "Ford Fiesta (2017)");
        PassengerCar HyundaiAccent = new PassengerCar(1804, 13000, 11.5, "Hyundai Accent(2017)");
        PassengerCar KiaForte = new PassengerCar(1379, 25000, 9.5, "Kia Forte(2017)");
        Random random = new Random();
        int i = random.nextInt(3) + 1;
        switch (i) {
            case 1:
                return FordFiesta;
            case 2:
                return HyundaiAccent;
            case 3:
                return KiaForte;
            default:
                return FordFiesta;
        }
    }

    public static PassengerCar hatchback() {
        PassengerCar AudiA7 = new PassengerCar(1750, 60000, 8.4, "Audi A7 (2017)");
        PassengerCar PorschePanamera = new PassengerCar(1644, 85000, 5.5, "Porsche Panamera(2017)");
        PassengerCar LexusCT200h = new PassengerCar(1727, 50000, 10.5, "Lexus CT200h (2017)");
        Random random = new Random();
        int i = random.nextInt(3) + 1;
        switch (i) {
            case 1:
                return AudiA7;
            case 2:
                return PorschePanamera;
            case 3:
                return LexusCT200h;
            default:
                return PorschePanamera;
        }
    }

}

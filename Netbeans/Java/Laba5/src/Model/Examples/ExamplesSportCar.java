package Model.Examples;

import Model.SportCar;
import java.util.Random;

public class ExamplesSportCar {
    public static SportCar sportEx(){
        SportCar BugattiChiron = new SportCar(1500, 2_500_000, 2.4, "Bugatti Chiron");
        SportCar AstonMartinValkyrieAM_RB001 = new SportCar(1100, 2_000_000, 2.5, "Aston Martin Valkyrie AM-RB 001");
        SportCar KoenigseggRegeraKDD = new SportCar(1023, 1_654_000, 3.5, " Koenigsegg Regera KDD");
        Random random = new Random();
        int i = random.nextInt(3) + 1;
        switch (i) {
            case 1:
                return BugattiChiron;
            case 2:
                return AstonMartinValkyrieAM_RB001;
            case 3:
                return KoenigseggRegeraKDD;
            default:
                return BugattiChiron;
        }
        
    }
}

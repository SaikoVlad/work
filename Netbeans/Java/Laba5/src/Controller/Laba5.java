package Controller;

import Model.Examples.ExamplesPassanger;
import Model.Examples.ExamplesSportCar;
import Model.Examples.ExamplesTruck;
import Model.PassengerCar;
import Model.SportCar;
import Model.Truck;
import View.Output;
import java.util.Random;
import java.util.Scanner;

public class Laba5 {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Output.writeLine("Hello,take a choise");
        menu();
        
    }

    private static void menu() {
        boolean work = true;
        String item = "";
        while (work) {
            Output.write("Input type of car you wanted(Passanger(1),SportCar(2) or Truck(3)):  ");
            String choise = scanner.next();
            if (choise.equals("Passanger")||choise.equals("passanger") ||choise.equals("1")) {
                Output.writeLine("Sedan or hatchback?");
                String choise1 = scanner.next();
                if (choise1.equals("Sedan") || choise1.equals("sedan") || choise.equals("2")) {
                    Output.writeLine("" + ExamplesPassanger.sedan().writeInfo());
                } else if (choise1.equals("hatchback")) {
                    Output.writeLine("" + ExamplesPassanger.hatchback().writeInfo());
                } else {
                    Output.write("oh,none!");
                }
            } else if (choise.equals("SportCar")||choise.equals("2") || choise.equals("Sport Car") || choise.equals("sportCar") || choise.equals("Sportcar") || choise.equals("Sport car") || choise.equals("sport Car") || choise.equals("sport car")) {
                Output.writeLine("" + ExamplesSportCar.sportEx().writeInfo());
            } else if (choise.equals("Truck")||choise.equals("3") || choise.equals("truck")) {
                Output.writeLine("" + ExamplesTruck.exTruck().writeInfo());
            }else{
                Output.writeLine("Something went wrong. Try again");
            }
            Output.write("Press 1 to continue or other key to exit: ");
            item = scanner.next();
            if (item != "1"){
                System.exit(0);
            }
        }
        
    }

    private static void randomMachine() {
        int i = random.nextInt(3) + 1;
        switch (i) {
            case 1:
                PassengerCar pscar = new PassengerCar(2500, 105000, 10, "Mercedes benz A-series(2017)");
                Output.writeLine("We could recomend you this...");
                Output.writeLine(pscar.writeInfo());
                break;
            case 2:
                Truck truck = new Truck(5000, 30000, 355, "Volvo FH16 750(2012)");
                Output.writeLine("I found this.");
                Output.writeLine(truck.writeInfo());
                break;
            case 3:
                SportCar sportcar = new SportCar(1500, 99999, 10, "Audi R8 (2016)");
                Output.writeLine("Maybe,this is for you...");
                Output.writeLine(sportcar.writeInfo());
                break;
            default:
                Output.writeLine(i);
        }
    }

}

package Model.data;

import Model.entity.Garland;
import Model.entity.Lights;
import Model.entity.StuffedToys;
import Model.entity.abstracts.Toy;
import Model.exceptions.IncorrectClassException;

public class DatabaseFilling {

    public static void PutInDataBase(Toy toy) throws IncorrectClassException {

        if (toy instanceof Garland){
            garlandObject(toy);
        }else if (toy instanceof Lights){
            lightsObject(toy);
        }else if (toy instanceof StuffedToys){
            stuffedObject(toy);
        }else {
            throw new IncorrectClassException("No class");
        }

    }

    private static void garlandObject(Toy toy){

    }

    private static void lightsObject(Toy toy){

    }

    private static void stuffedObject(Toy toy){

    }



}

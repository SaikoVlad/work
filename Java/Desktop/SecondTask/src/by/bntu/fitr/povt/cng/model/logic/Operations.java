package by.bntu.fitr.povt.cng.model.logic;

import by.bntu.fitr.povt.cng.model.entity.Vector;

public class Operations {

    public static Vector getNewVector(Vector vector, double max){
        Vector newVector = new Vector();
        for (int i = 0; i < vector.size(); i++) {
            if (i % 2 == 0){
                newVector.add(vector.getElement(i)/max);
            }else{
                newVector.add(vector.getElement(i));
            }
        }
        return newVector;
    }

    public static double getMax(Vector vector){
        double max = vector.getElement(0);
        for (int i = 0; i < vector.size() ; i++) {
            if (vector.getElement(i) > max){
                max = vector.getElement(i);
            }
        }
        return max;
    }


}

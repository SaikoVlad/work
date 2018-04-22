package by.bntu.fitr.povt.prostrmk.model.logic;

import by.bntu.fitr.povt.prostrmk.model.entity.SuperVector;

public class VectorWorker {

    public static double calcSumOfNegativeElements(SuperVector vector) {
        double sum = 0;

        for (int i = 0; i < vector.size(); i++) {
            if (vector.getElement(i) < 0) {
                sum += vector.getElement(i);
            }
        }

        return sum;
    }

    private static int getIndexMaxElement(SuperVector vector){
        int index = 0;
        
        for (int i = 1; i < vector.size(); i++) {
            if (vector.getElement(i) > vector.getElement(index)) {
                index = i;
            }
        }
        
        return index;
    }
    
    
    private static int getIndexMinElement(SuperVector vector){
        int index = 0;
        
        for (int i = 1; i < vector.size(); i++) {
            if (vector.getElement(i) < vector.getElement(index)) {
                index = i;
            }
        }
        
        return index;
    }
    
    public static double calcMultiplicationElementsBetweenMaxAndMin(SuperVector vector) {
        double mult = 1;
        
        int indexMax = getIndexMaxElement(vector);
        int indexMin = getIndexMinElement(vector);
        
        if (indexMax < indexMin){
            int t = indexMax;
            indexMax = indexMin;
            indexMin = t;
        }
        
        for (int i = indexMin + 1; i < indexMax; i++) {
            mult *= vector.getElement(i);
        }
        
        return mult;
    }
}

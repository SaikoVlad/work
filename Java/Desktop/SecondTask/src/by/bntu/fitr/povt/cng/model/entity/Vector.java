package by.bntu.fitr.povt.cng.model.entity;

public class Vector {
    private double[] vector;

    public Vector(double... vector) {
         this.vector = vector;
    }

    
    public int size(){
        return vector.length;
    }

    public double getElement(int index){
        if (index >= 0 && index < vector.length){
            return vector[index];
        }        
        throw new ArrayIndexOutOfBoundsException();
    }

    public void add(double element){
        int index = vector.length;
        double[] temp = new double[vector.length + 1];
        for (int i = 0; i < vector.length; i++) {
            if (i < index) {
                temp[i] = vector[i];
            } else {
                temp[i + 1] = vector[i];
            }
        }
        temp[index] = element;
        vector = temp;
    }

        
    @Override
    public String toString() {

        String out = "";
        for (int i = 0; i < vector.length; i++) {
            out += (vector[i] + "\t");
        }

        return  out;
    }
}

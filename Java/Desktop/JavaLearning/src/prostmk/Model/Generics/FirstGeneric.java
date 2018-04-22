package prostmk.Model.Generics;

import java.util.*;

public class FirstGeneric <Param> implements SimpleList{



    private Object[] masOfObjects;

    public FirstGeneric(Param...params){
        this.masOfObjects = params;
    }

    @Override
    public int size() {
        return masOfObjects.length;
    }

    @Override
    public boolean add(Object param) {
        try{
            int index = masOfObjects.length;
            Object[] temp = new Object[masOfObjects.length + 1];
            for (int i = 0; i < masOfObjects.length; i++) {
                if (i < index) {
                    temp[i] = masOfObjects[i];
                } else {
                    temp[i + 1] = masOfObjects[i];
                }
            }
            temp[index] = param;
            masOfObjects = temp;
        } catch (NullPointerException e){
            masOfObjects = new Object[1];
            masOfObjects[0] = param;
        }
        return true;
    }

    public Param getElement(int index){
        return (Param) masOfObjects[index];
    }

    @Override
    public boolean isEmpty() {
        return masOfObjects[0].equals(null);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void sort() {

    }

    @Override
    public boolean contains(Object object) {
        for (int i = 0; i < masOfObjects.length; i++) {
            if (masOfObjects[i].equals(object)){
                return true;
            }
        }
        return false;
    }

}

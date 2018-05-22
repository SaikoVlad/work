package by.bntu.fitr.povt.cng.model.collections.deprecated;

import java.util.*;

public class StackListImpl<T> implements Stack<T>, CustomCollections<T>, Iterable<T> {

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;


    public StackListImpl() {

    }

    @SafeVarargs
    public StackListImpl(T... params) {
        for (T param : params) {
            add(param);
        }
    }

    public void push(T t) {
        add(t);
    }

    @Override
    public boolean add(T item) {
        if (pointer == array.length - 1){
            resize(array.length * 2);
        }
        array[pointer++] = item;
        return true;
    }

    public T pop() {
        T returner = (T) array[size() - 1];
        removeByIndex(size() - 1);
        return returner;
    }


    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public Object[] CollectionToArray() {
        Object[] objects = new Object[size()];
        System.arraycopy(array, 0, objects, 0, size());
        return objects;
    }

    @Deprecated
    @Override
    public void setElement(int index, T t) {

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < pointer;
            }


            @Override
            public T next() {
                return (T) array[index++];
            }
        };
    }


    public Object[] toArray() {
        Object[] objects = new Object[size()];
        System.arraycopy(array, 0, objects, 0, size());
        return objects;
    }

    @Override
    public synchronized boolean isEmpty() {
        return pointer == 0;
    }


    private void removeByIndex(int index) {
        System.arraycopy(array, index + 1, array, index, pointer - index);
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE) {
            resize(array.length / 2);
        }


    }

    @Override
    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }


    @Override
    public boolean equals(Object o) {
        return o != null && this.hashCode() == o.hashCode() && this.getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        final int CONSTVAR = 31;
        int result = 1;
        result = CONSTVAR * result + size();
        for (int i = 0; i < size(); i++) {
            result = CONSTVAR * result + array[i].hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("Stack content:\n");
        for (Object a : array) {
            if (a != null) {
                sb.append(a.toString()).append("\n");
            } else {
                sb.append("Object is empty\n");
            }
        }
        return sb.toString();
    }

}

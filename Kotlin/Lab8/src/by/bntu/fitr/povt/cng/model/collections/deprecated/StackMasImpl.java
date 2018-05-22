package by.bntu.fitr.povt.cng.model.collections.deprecated;

import java.util.Iterator;

public class StackMasImpl<T> implements CustomCollections<T>,Stack<T>, Iterable<T> {

    private Object[] stackArray = new Object[1];

    public StackMasImpl() {

    }

    public StackMasImpl(T... params) {
        stackArray = new Object[params.length];
        for (int i = 0; i < stackArray.length; i++) {
            stackArray[i] = params[i];
        }
    }

    @Override
    public int size() {
        return stackArray.length;
    }

    @Deprecated
    public void addEl(T element) {
        try {
            int index = stackArray.length;
            Object[] temp = new Object[stackArray.length + 1];
            for (int i = 0; i < stackArray.length; i++) {
                if (i < index) {
                    temp[i] = stackArray[i];
                } else {
                    temp[i + 1] = stackArray[i];
                }
            }
            temp[index] = element;
            stackArray = temp;
        } catch (NullPointerException e) {
            stackArray = new Object[1];
            stackArray[0] = element;
        }
    }

    @Override
    public void push(T element) {
        try {
            Object[] temp = new Object[stackArray.length + 1];
            for (int i = 0; i < stackArray.length; i++) {
                temp[i] = stackArray[i];
            }
            temp[stackArray.length] = element;
            stackArray = temp;
        } catch (NullPointerException e) {
            stackArray = new Object[1];
            stackArray[0] = element;
        }
    }

    @Deprecated
    @Override
    public void setElement(int index, T param) {
        stackArray[index] = param;
    }


    @Override
    public T get(int index){
        return (T) stackArray[index];
    }

    @Override
    public T pop() {
        T ret = (T) stackArray[stackArray.length - 1];
        try {

            Object[] temp = new Object[stackArray.length - 1];
            for (int i = 0; i < stackArray.length - 1; i++) {
                temp[i] = stackArray[i];

            }
            stackArray = temp;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(T param) {
        push(param);
        return true;
    }

    @Override
    public Object[] CollectionToArray() {
        return stackArray;
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
        for (Object aStackArray : stackArray) {
            result = CONSTVAR * result + aStackArray.hashCode();
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return !(index == size());
            }

            @Override
            public T next() {
                return (T) stackArray[index++];
            }
        };
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack content:\n");
        for (int i = 0; i < stackArray.length; i++) {
            sb.append(stackArray[i]).append("\n");
        }
        return sb.toString();
    }
}

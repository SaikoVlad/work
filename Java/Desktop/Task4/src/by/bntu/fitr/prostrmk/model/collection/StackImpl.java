package by.bntu.fitr.prostrmk.model.collection;

public class StackImpl<T> implements CustomCollection<T> {

    private Object[] stackArray = new Object[0];

    public StackImpl() {

    }



    public StackImpl(T... params) {
        stackArray = new Object[params.length];
        for (int i = 0; i < stackArray.length; i++) {
            stackArray[i] = params[i];
        }
    }




    @Override
    public int size() {
        return stackArray.length;
    }


    public boolean add(T param) {
        try {
            Object[] temp = new Object[stackArray.length + 1];
            for (int i = 0; i < stackArray.length; i++) {
                temp[i] = stackArray[i];
            }
            temp[stackArray.length] = param;
            stackArray = temp;
        } catch (NullPointerException e) {
            stackArray = new Object[1];
            stackArray[0] = param;
        } catch (Exception e) {
            return false;
        }
        return true;

    }


    @Override
    public T pop() {
        T returner = (T) stackArray[stackArray.length - 1];
        Object []temp = new Object[stackArray.length - 1];
        System.arraycopy(stackArray, 0, temp, 0, stackArray.length - 1);
        stackArray = temp;
        return returner;
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object aStackArray : stackArray) {
            sb.append(aStackArray);
        }
        return sb.toString();
    }

}

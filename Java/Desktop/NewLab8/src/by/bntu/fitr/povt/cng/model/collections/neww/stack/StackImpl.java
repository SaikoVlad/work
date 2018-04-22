package by.bntu.fitr.povt.cng.model.collections.neww.stack;

import by.bntu.fitr.povt.cng.model.collections.neww.AbstractCollection;

import java.util.Iterator;

public class StackImpl<T> extends AbstractCollection<T> implements StackInterface<T> {

    private Object[] stack = new Object[4];
    private int sizeVar;
    private int stackArraySize = 4;

    public StackImpl(){
    }

    public StackImpl(T...ts){
        for (T t : ts) {
            push(t);
        }
    }

    @Override
    public int size() {
        return sizeVar;
    }

    @Override
    protected void add(T t) {
        push(t);
    }

    @Override
    public T peek() {
        return (T) stack[sizeVar - 1];
    }

    @Override
    public void push(T t) {
        if (sizeVar == stackArraySize - 1){
            resize(stackArraySize * 2);
        }
        stack[sizeVar++] = t;
    }

    @Override
    public T pop() {
        T t = (T) stack[sizeVar - 1];
        stack[sizeVar--] = null;
        return t;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < sizeVar;
            }

            @Override
            public T next() {
                return (T) stack[index++];
            }
        };

    }

    @Override
    public void clear() {
        stack = new Object[4];
        sizeVar = 0;
    }

    @Override
    public int hashCode() {
        final int HASHCONST = 31;
        int result = 1;
        for (Object o : this) {
            result += result * HASHCONST + o.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode() && obj.getClass() == this.getClass();
    }

    //PRIVATE METHODS
    private void resize(int newLength) {
        stackArraySize = newLength;
        Object[] newArray = new Object[newLength];
        System.arraycopy(stack, 0, newArray, 0, sizeVar);
        stack = newArray;
    }

}

package by.bntu.fitr.povt.cng.model.collections.deprecated;


import java.util.*;

public class QueueListImpl<T> implements Queue<T>, CustomCollections<T> {

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] listArray = new Object[INIT_SIZE];
    private int indexer = 0;


    public QueueListImpl() {

    }

    @SafeVarargs
    public QueueListImpl(T... params) {
        addAll(Arrays.asList(params));
    }

    @Override
    public boolean remove(T t) {
        for (int i = 0; i < size(); i++) {
            if (listArray[i].equals(t)) {
                removeByIndex(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<? extends T> c) {
        int count = 0;
        for (T t : c) {
            for (int i = 0; i < size(); i++) {
                if (t.equals(listArray[i])) {
                    removeByIndex(i);
                    count++;
                }
            }
        }
        return count == c.size();
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i < size(); i++) {
            if (t.equals(listArray[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends T> c) {
        int count = 0;
        for (T t : c) {
            for (int i = 0; i < size(); i++) {
                if (t.equals(listArray[i])) {
                    count++;
                }
            }
        }
        return count == c.size();
    }

    @Override
    public void setElement(int index, T t) {
        Object o = listArray[size() - 1];
        for (int i = size(); i >= index; i--) {
            listArray[i+1] = listArray[i];
        }
        listArray[index] = t;
        add((T) o);
    }

    @Override
    public void clear() {
        indexer = 0;
        listArray = new Object[INIT_SIZE];
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean add(T item) {
        if (indexer == listArray.length - 1)
            resize(listArray.length * 2);
        listArray[indexer++] = item;
        return true;
    }

    @Override
    public T get(int index) {
        return (T) listArray[index];
    }

    @Override
    public Object[] CollectionToArray() {
        Object[] objects = new Object[size()];
        System.arraycopy(listArray, 0, objects, 0, size());
        return objects;
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index != indexer;
            }

            @Override
            public T next() {
                return (T) listArray[index++];
            }
        };
    }


    public Object[] toArray() {
        Object[] objects = new Object[size()];
        System.arraycopy(listArray, 0, objects, 0, size());
        return objects;
    }

    @Override
    public synchronized boolean isEmpty() {
        return indexer == 0;
    }


    private void removeByIndex(int index) {
        System.arraycopy(listArray, index + 1, listArray, index, indexer - index);
        listArray[indexer] = null;
        indexer--;
        if (listArray.length > INIT_SIZE && indexer < listArray.length / CUT_RATE) {
            resize(listArray.length / 2);
        }


    }

    @Override
    public int size() {
        return indexer;
    }


    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(listArray, 0, newArray, 0, indexer);
        listArray = newArray;
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
            result = CONSTVAR * result + listArray[i].hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("Stack content:\n");
        for (int i = 0; i < size(); i++) {
            sb.append(listArray[i]).append("\n");
        }
        return sb.toString();
    }


}

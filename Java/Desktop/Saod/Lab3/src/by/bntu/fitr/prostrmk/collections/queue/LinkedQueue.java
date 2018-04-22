package by.bntu.fitr.prostrmk.collections.queue;
import by.bntu.fitr.prostrmk.collections.AbstractCollection;
import by.bntu.fitr.prostrmk.collections.CngCollection;
import by.bntu.fitr.prostrmk.collections.Link;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Comparator;
import java.util.Iterator;

public class LinkedQueue<T> extends AbstractCollection<T> implements CngCollection<T> {
    private Link<T> front, end;
    private int size;
    private Comparator comparator;
    public LinkedQueue() {
        front = null;
        end = null;
        size = 0;
    }
    public LinkedQueue(Comparator comparator) {
        front = null;
        end = null;
        size = 0;
        this.comparator = comparator;
    }
    public void put(T t) {
        if (comparator == null) {
            throw new NotImplementedException();// if no comparator
        }
        enqueue(t);
        T[] ts = toArray();
        ts = bubbleSort(ts);
        size = 0;
        for (int i = 0; i < ts.length; i++) {
            enqueue(ts[i]);
        }
    }
    private void enqueue(T t) {
        if (size == 0) {
            front = new Link<T>(t, null, null);
            end = front;
        } else {
            end.setNextNode(new Link<>(t, end, null));
            end = end.getNextNode();
        }
        size++;
    }
    private T poll() {
        Link<T> rm = front;
        if (size == 0) {
            return null;
        } else {
            front = front.getNextNode();
        }
        size--;
        return rm.getElement();
    }
    public int size() {
        return size;
    }

    @Override
    protected void add(T t) {
        enqueue(t);
    }
    public T[] toArray() {
        Object[] objects = new Object[size()];
        Iterator iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            objects[i] = iterator.next();
            i++;
        }
        return (T[]) objects;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            LinkedQueue<T> linkedQueue = LinkedQueue.this;
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }
            @Override
            public T next() {
                return linkedQueue.poll();
            }
        };
    }

    public T[] bubbleSort(T[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

}

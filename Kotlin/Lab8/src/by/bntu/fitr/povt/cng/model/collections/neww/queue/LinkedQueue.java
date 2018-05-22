package by.bntu.fitr.povt.cng.model.collections.neww.queue;


import by.bntu.fitr.povt.cng.model.collections.neww.AbstractCollection;
import by.bntu.fitr.povt.cng.model.collections.neww.Link;

import java.util.Arrays;
import java.util.Iterator;

public class LinkedQueue<T> extends AbstractCollection<T> implements QueueInterface<T> {


    private Link<T> front, end;
    private int size;

    public LinkedQueue() {
        front = null;
        end = null;
        size = 0;
    }

    public LinkedQueue(T...ts){
        front = null;
        end = null;
        size = 0;
        addAll(Arrays.asList(ts));
    }

    @Override
    public void enqueue(T t){
        if (size == 0) {
            front = new Link<T>(t, null, null);
            end = front;
        } else {
            end.setNextNode(new Link<>(t, end, null));
            end = end.getNextNode();
        }
        size++;
    }


    @Override
    public T dequeue() {
        Link<T> rm = front;
        if (size == 0) {
            return null;
        } else {
            front = front.getNextNode();
        }
        size--;
        return rm.getElement();
    }

    @Override
    public T peek(){
        if(size == 0){
            return null;
        }
        return end.getElement();
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    protected void add(T t) {
        enqueue(t);
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
                return linkedQueue.dequeue();
            }
        };
    }

    @Override
    public void clear() {

        for (Link<T> tLink = front; tLink!=null; ){
            Link<T> next = tLink.getNextNode();
            tLink.setNextNode(null);
            tLink.setPrevNode(null);
            tLink.setElement(null);
            tLink = next;
        }
        front = end = null;
        size = 0;
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
        return this.hashCode() == obj.hashCode() && obj instanceof LinkedQueue;
    }



}

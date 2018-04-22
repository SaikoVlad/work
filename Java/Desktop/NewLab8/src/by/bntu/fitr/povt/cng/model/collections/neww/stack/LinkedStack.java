package by.bntu.fitr.povt.cng.model.collections.neww.stack;

import by.bntu.fitr.povt.cng.model.collections.neww.AbstractCollection;
import by.bntu.fitr.povt.cng.model.collections.neww.Link;


import java.util.Iterator;

public class LinkedStack<T> extends AbstractCollection<T> implements StackInterface<T> {
    private Link<T> front, end;

    private int size;

    public LinkedStack() {
        front = null;
        end = null;
        size = 0;
    }

    public LinkedStack(T...ts){
        front = null;
        end = null;
        size = 0;
        for (T t : ts){
            add(t);
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    protected void add(T t) {
        push(t);
    }

    @Override
    public T peek(){
        return end.getElement();
    }

    @Override
    public void push(T t) {
        if (size == 0) {
            front = new Link<T>(t, null, null);
            end = front;
        } else {
            end.setNextNode(new Link<T>(t, end, null));
            end = end.getNextNode();
        }
        size++;
    }

    @Override
    public T pop() {
        Link<T> rm = end;
        if (size == 0) {
            return null;
        } else if (size == 1) {
            front = null;
        } else {
            end = end.getPrevNode();
            end.setNextNode(null);
        }
        size--;
        return rm.getElement();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            LinkedStack<T> linkedStack = LinkedStack.this;
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public T next() {
                return linkedStack.pop();
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
        return this.hashCode() == obj.hashCode() && obj.getClass() == this.getClass();
    }

}

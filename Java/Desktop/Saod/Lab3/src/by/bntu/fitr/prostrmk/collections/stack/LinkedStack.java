package by.bntu.fitr.prostrmk.collections.stack;

import by.bntu.fitr.prostrmk.collections.AbstractCollection;
import by.bntu.fitr.prostrmk.collections.Link;

import java.util.Iterator;

public class LinkedStack<T> extends AbstractCollection<T> implements StackInterface<T> {

    private Link<T> front, end;
    private int size;

    public LinkedStack() {
        front = null;
        end = null;
        size = 0;
    }

    public void push(T x) {
        if (size == 0) {
            front = new Link<T>(x, null, null);
            end = front;
        } else {
            end.setNextNode(new Link<T>(x, end, null));
            end = end.getNextNode();
        }
        size++;
    }

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
    public int size(){
        return size;
    }

    @Override
    protected void add(T t) {
        push(t);
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
    public T peek(){
        return end.getElement();
    }

}

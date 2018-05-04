package by.bntu.fitr.prostrmk.CustomGraph;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {


    private Node<T> first;    // beginning of bag
    private int n;               // number of elements in bag


    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }


    public Bag() {
        first = null;
        n = 0;
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }


    public void add(T t) {
        Node<T> oldfirst = first;
        first = new Node<T>();
        first.item = t;
        first.next = oldfirst;
        n++;
    }


    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }


    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        ListIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T t = current.item;
            current = current.next;
            return t;
        }
    }

}

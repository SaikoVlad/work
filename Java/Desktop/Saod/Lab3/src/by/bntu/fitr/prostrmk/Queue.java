package by.bntu.fitr.prostrmk;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{

    private class Link<T> {
        Link<T> prev;
        T current;
        Link<T> next;
        public Link(T current, Link<T> prev,  Link<T> next) {
            this.prev = prev;
            this.current = current;
            this.next = next;
        }
    }
    private Link<T> fstLink;
    private Link<T> lstLink;
    private int size = 0;
    public Queue() {
        lstLink = new Link<T>(null, fstLink, null);
        fstLink = new Link<T>(null,null, lstLink);
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T t){
        Link<T> prev = lstLink;
        prev.current = t;
        lstLink = new Link<T>(null,prev,null);
        prev.next = lstLink;
        size++;
    }

    public void dequeue(){
        lstLink.prev.next = null;
    }

    public T getByIndex(int index){
        Link<T> link = fstLink.next;
        for (int i = 0; i < index; i++) {
            link = getNextElement(link);
        }
        return link.current;
    }

    private Link getNextElement(Link current){
        return current.next;
    }

    private void sort(){
        //todo sort method
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }
            @Override
            public T next() {
                return getByIndex(index++);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator iterator = iterator();
        while (iterator.hasNext()){
            sb.append(iterator.next()).append("\n");
        }
        return sb.toString();
    }
}

package by.bntu.fitr.prostrmk.collections;

public class Link<T> {


    private T element;
    private Link<T> nextNode, prevNode;

    public Link(T value, Link<T> prev, Link<T> next) {
        element = value;
        nextNode = next;
        prevNode = prev;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Link<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Link<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Link<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Link<T> prevNode) {
        this.prevNode = prevNode;
    }


}

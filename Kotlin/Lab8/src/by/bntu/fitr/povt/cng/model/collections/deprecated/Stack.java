package by.bntu.fitr.povt.cng.model.collections.deprecated;

import java.util.Iterator;

public interface Stack<T> {
    int size();
    void push(T t);
    T pop();
    String toString();
    Iterator<T> iterator();
}

package by.bntu.fitr.povt.cng.model.collections.deprecated;

import java.util.Collection;
import java.util.Iterator;

public interface Queue<T> {

    boolean add(T t);
    boolean addAll(Collection<? extends T> c);
    boolean contains(T t);
    boolean containsAll(Collection<? extends T> c);
    boolean remove(T t);
    boolean removeAll(Collection<? extends T> c);
    void clear();
    boolean isEmpty();
    int size();
    Iterator<T> iterator();
    Object []toArray();

}

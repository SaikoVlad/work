package by.bntu.fitr.prostrmk.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection<T> implements CngCollection<T> {

    public abstract int size();
    public boolean isEmpty(){
        return size() == 0;
    }

    protected abstract void add(T t);

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!contains(o)){
                return false;
            }
        }
        return true;
    }

    public abstract Iterator<T> iterator();

    @Override
    public Object[] toArray() {
        Object []objects = new Object[size()];
        Iterator iterator = iterator();
        for (int i = 0; i < objects.length; i++) {
            if (! iterator.hasNext())
                return Arrays.copyOf(objects, i);
            objects[i] = iterator.next();
        }
        return objects;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        Iterator iterator = iterator();
        while(iterator.hasNext()){
            if (iterator.next().equals(o)){
                return true;
            }
        }
        return false;
    }

    public void addAll(Collection c) {
        for (Object o : c) {
            add((T) o);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this){
            sb.append(t).append("\n");
        }
        return sb.toString();
    }
}

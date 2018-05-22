package by.bntu.fitr.povt.cng.model.collections.deprecated;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueMasImpl<Param> implements Queue<Param>, CustomCollections<Param> {

    private Object []queue = new Object[0];

    public QueueMasImpl(){

    }

    @SafeVarargs
    public QueueMasImpl(Param...params){
        queue = params;
    }

    @Override
    public Param get(int index) {
        return (Param) queue[index];
    }

    @Override
    public int size() {
        return queue.length;
    }

    @Override
    public boolean isEmpty() {
        return queue[0]==null;
    }

    @Override
    public boolean contains(Object o) {
        for (Object p : queue){
            if (p.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Param> iterator() {
        return new Iterator<Param>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < queue.length;
            }

            @Override
            public Param next() {
                return (Param) queue[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return queue;
    }

    @Override
    public Object[] CollectionToArray() {
        return queue;
    }

    @Override
    public void setElement(int index, Param param) {
        queue[index] = param;
    }

    @Override
    public <Param> Param[] toArray(Param[] a) {
        return (Param[]) queue;
    }

    @Override
    public boolean add(Param param) {
        try {
            Object[] temp = new Object[queue.length + 1];
            for (int i = 0; i < queue.length; i++) {
                temp[i] = queue[i];
            }
            temp[queue.length] = param;
            queue = temp;
        } catch (NullPointerException e) {
            queue = new Object[1];
            queue[0] = param;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < queue.length; i++) {
            if (queue[i].equals(o)){
                deleteByIndex(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int eq = 0;
        for (int i = 0; i < queue.length; i++) {
            for (Object object : c){
                if (object.equals(queue[i])){
                   eq++;
                }
            }
        }
        return eq == c.size();
    }

    @Override
    public boolean addAll(Collection<? extends Param> c) {
        for (Object o : c){
            add((Param) o);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isDeleted = false;
        for (Object collection: c){
            for (int i = 0; i < queue.length; i++) {
                if (collection.equals(queue[i])){
                    deleteByIndex(i);
                    isDeleted = true;
                }
            }
        }
        return isDeleted;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        QueueMasImpl <Param> temp = new QueueMasImpl<>();
        boolean ok = true;
        for (Object object : c){
            for (int i = 0; i < queue.length; i++) {
                if (object.equals(queue)){
                    temp.add((Param) queue[i]);
                }else{
                    ok = false;
                }
            }
        }
        queue = temp.CollectionToArray();
        return ok;
    }

    @Override
    public void clear() {
        queue = null;
    }

    @Override
    public boolean offer(Param param) {
        return add(param);
    }

    @Override
    public Param remove() {
        if (queue == null){
            throw new NoSuchElementException("Collection is empty!");
        }
        Object o = queue[0];
        deleteByIndex(0);
        return (Param) o;
    }

    @Override
    public Param poll() {
        if (queue==null){
            return null;
        }
        Object o = queue[0];
        deleteByIndex(0);
        return (Param) o;
    }

    @Override
    public Param element() {
        if (queue!=null){
            return (Param) queue[0];
        }
        throw new NoSuchElementException("Collection is empty!");
    }

    @Override
    public Param peek() {
        if (queue!=null){
            return (Param) queue[0];
        }
        return null;
    }


    @Override
    public int hashCode() {
        final int CONSTVAR = 31;
        int result = 1;
        result = CONSTVAR * result + size();
        for (Object aStackArray : queue) {
            result = CONSTVAR * result + aStackArray.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o != null && this.hashCode() == o.hashCode() && this.getClass() == o.getClass();
    }

    public void deleteByIndex(int index) {
        Object []objects = new Object[queue.length - 1];
        System.arraycopy(queue, 0, objects, 0, index);
        System.arraycopy(queue, index + 1, objects, index , queue.length - index -1 );
        queue = objects;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object aQueue : queue) {
            stringBuilder.append("\n").append(aQueue.toString());
        }
        return stringBuilder.toString();
    }

}

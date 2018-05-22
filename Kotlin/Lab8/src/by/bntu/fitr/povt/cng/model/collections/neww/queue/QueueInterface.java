package by.bntu.fitr.povt.cng.model.collections.neww.queue;

import by.bntu.fitr.povt.cng.model.collections.neww.CngCollection;

import java.util.Collection;

public interface QueueInterface<T> extends CngCollection<T> {

    void enqueue(T t);
    T dequeue();
    T peek();


    //boolean isFull();

}

package by.bntu.fitr.prostrmk.collections.queue;

import by.bntu.fitr.prostrmk.collections.CngCollection;

import java.util.Collection;

public interface QueueInterface<T> extends CngCollection<T> {

    void enqueue(T t);
    T dequeue();
    T peek();

}

package by.bntu.fitr.prostrmk.collections.stack;

import by.bntu.fitr.prostrmk.collections.CngCollection;

public interface StackInterface<T> extends CngCollection<T> {

    void push(T t);
    T pop();
    T peek();

}

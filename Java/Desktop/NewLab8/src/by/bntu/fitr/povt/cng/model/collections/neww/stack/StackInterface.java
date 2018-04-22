package by.bntu.fitr.povt.cng.model.collections.neww.stack;

import by.bntu.fitr.povt.cng.model.collections.neww.CngCollection;

public interface StackInterface<T> extends CngCollection<T> {

    void push(T t);
    T pop();
    T peek();

}

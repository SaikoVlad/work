package by.bntu.fitr.prostrmk.model.collection;

public interface CustomCollection<T> {

    boolean add(T param);
    T pop();
    int size();
    boolean isEmpty();
    Object[] CollectionToArray();



}

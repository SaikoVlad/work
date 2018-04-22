package prostmk.Model.Generics;

public interface SimpleList <Param> {

    boolean add(Param param);
    boolean isEmpty();
    boolean remove(Param param);
    boolean contains(Object object);
    void clear();
    void sort();
    int size();



}

package by.bntu.fitr.povt.cng.model.collections.deprecated;

public interface CustomCollections <Param> {

    boolean add(Param param);
    Param get(int index);
    int size();
    boolean isEmpty();
    Object[] CollectionToArray();
    void setElement(int index, Param param);



}

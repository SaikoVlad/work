package by.bntu.fitr.povt.cng.model.entity.container.JSFContainer;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

public interface JSFTrees extends Iterable<Toy> {

    int getSizeOfTree();
    void remove(int index);
    void changeToy(Toy toy, int index);
    void add(Toy toy);
    Toy[] getMasOfObjects();
    Toy getToy(int index);

}

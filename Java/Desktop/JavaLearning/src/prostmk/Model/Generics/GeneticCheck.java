package prostmk.Model.Generics;

import java.util.ArrayList;

public class GeneticCheck <Param> extends ArrayList implements SimpleList {



    ArrayList<Param> list;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.format("\n%s",list.get(i).toString()));
        }
        return sb.toString();
    }

    @Override
    public boolean add(Object o) {
        return super.add(o);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean remove(Object o) {
        return super.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return super.contains(object);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void sort() {
//        super.sort();
    }

    @Override
    public int size() {
        return list.size();
    }
}

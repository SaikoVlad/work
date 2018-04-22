package by.bntu.fitr.povt.cng.model.entity.container.JSFContainer;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class JSFLinkedTree implements JSFTrees{

    private LinkedList<Toy> toys = new LinkedList<>();

    public JSFLinkedTree(Toy...ts) {
        toys.addAll(Arrays.asList(ts));
    }

    public JSFLinkedTree(){

    }

    public Toy[] getMasOfObjects(){
        return (Toy[]) toys.toArray();
    }

    public Toy getToy(int index){
        return toys.get(index);
    }

    public void changeToy(Toy toy, int index){
        toys.remove(index);
        toys.add(index, toy);
    }

    public void remove(int index){
        toys.remove(index);
    }

    public void add(Toy toy){
        toys.add(toy);
    }

    public int getSizeOfTree(){
        return toys.size();
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (Toy toy : toys){
            result += toy.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null && !(obj instanceof JSFArrayTree)){
            return false;
        }
        return obj == this && this.hashCode() == obj.hashCode() && obj.getClass() == this.getClass();
    }

    @Override
    public Iterator<Toy> iterator() {
        return toys.iterator();
    }

    @Override
    public String toString() {
        return toys.toString();
    }

}

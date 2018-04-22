package by.bntu.fitr.povt.cng.model.entity.container;

import by.bntu.fitr.povt.cng.model.entity.Garland;
import by.bntu.fitr.povt.cng.model.entity.Lights;
import by.bntu.fitr.povt.cng.model.entity.StuffedToys;
import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

@Deprecated
public class Tree {

    private Toy[] toysMass;
    private static Tree tree = null;

    public static Tree getInstanceOfTree(ToyType...toysType){
        if (null == tree){
            tree = new Tree();
            for (int i = 0; i < toysType.length; i++) {
                if (toysType[i].equals(ToyType.GARLAND)){
                    tree.add(new Garland());
                }else if (toysType[i].equals(ToyType.LIGHTS)){
                    tree.add(new Lights());
                }else if (toysType[i].equals(ToyType.STUFFEDTOYS)){
                    tree.add(new StuffedToys());
                }
            }
        }
        return tree;
    }



    public Tree() {

    }

    private Tree(Toy... toys) {//mass
        this.toysMass = toys;
    }



    public Toy[] getToysMass() {
        return toysMass;
    }

    public int getSize(){
        return toysMass.length;
    }

    public Toy getToy(int index){
        return toysMass[index];
    }

    public void changeToy(Toy newToy, int index){
        toysMass[index] = newToy;
    }

    public void setToy(Toy newToy, int index){
        Toy[] temp = new Toy[toysMass.length + 1];
        for (int i = 0; i < toysMass.length; i++) {
            if (i < index) {
                temp[i] = toysMass[i];
            } else {
                temp[i + 1] = toysMass[i];
            }
        }
        temp[index] = newToy;
        toysMass = temp;
    }

    public double getPrice(int index){
        return toysMass[index].getPrice();
    }

    public void add(Toy newToy) {
        try{
            int index = toysMass.length;
            Toy[] temp = new Toy[toysMass.length + 1];
            for (int i = 0; i < toysMass.length; i++) {
                if (i < index) {
                    temp[i] = toysMass[i];
                } else {
                    temp[i + 1] = toysMass[i];
                }
            }
            temp[index] = newToy;
            toysMass = temp;
        } catch (NullPointerException e){
            toysMass = new Toy[1];
            toysMass[0] = newToy;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Toy toysMas : this.toysMass) {
            sb.append(toysMas.toString()).append("\n");
        }
        return sb.toString();
    }
}


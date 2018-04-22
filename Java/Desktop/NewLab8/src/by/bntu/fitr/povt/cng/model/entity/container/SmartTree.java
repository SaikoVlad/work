package by.bntu.fitr.povt.cng.model.entity.container;

import by.bntu.fitr.povt.cng.model.collections.deprecated.CustomCollections;
import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

public class SmartTree {

    private CustomCollections <Toy> toysMass = null;
    private static SmartTree tree = null;

    public SmartTree() {

    }

    public SmartTree(CustomCollections collections){
        toysMass = collections;
    }

    public static SmartTree getInstance(CustomCollections collections){
        return new SmartTree(collections);
    }

    public Toy[] getToysMass() {
        return (Toy[]) toysMass.CollectionToArray();
    }

    public int getSize(){
        return toysMass.size();
    }

    public Toy getToy(int index){
        return toysMass.get(index);
    }
    //priceTree
    public void changeToy(Toy newToy, int index){
        toysMass.setElement(index,newToy);
    }

    public void setToy(Toy newToy, int index){
        toysMass.setElement(index,newToy);
    }

    public double getPrice(int index){
        return toysMass.get(index).getPrice();
    }

    public void add(Toy...newToys) {
        for (Toy newToy : newToys){
            toysMass.add(newToy);
        }
    }

    @Override
    public int hashCode() {
        int HASHCONST = 31;
        int result = 1;
        result = HASHCONST * result + getSize();
        for (Object object : toysMass.CollectionToArray()){
            result = HASHCONST * result + object.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null && this.hashCode() == obj.hashCode() && obj.getClass() == this.getClass());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < toysMass.size(); i++) {
            sb.append(toysMass.get(i)).append("\n");
        }
        return sb.toString();
    }

}

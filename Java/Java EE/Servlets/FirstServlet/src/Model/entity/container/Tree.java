package Model.entity.container;


import Model.entity.abstracts.Toy;

public class Tree {
//        private ArrayList<Toy> toysList;
//    public Tree(Toy...toys){
//        this.toysList.addAll(Arrays.asList(toys));
//    }
    private Toy[] toysMass;

    public Tree() {

    }

    public Tree(Toy... toys) {//mass
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
//priceTree
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

package NewYearGift.Model.Entity.Container;

import NewYearGift.Model.Entity.Abstract.Candy;

public class Gift {

    private Candy[] candiesMass;

    public Gift() {

    }

    public Gift(Candy... candies) {//mass
        this.candiesMass = candies;
    }

    public Candy[] getCandiesMass() {
        return candiesMass;
    }

    public int getSize(){
        return candiesMass.length;
    }

    public Candy getCandy(int index){
        return candiesMass[index];
    }

    public void changeCandy(Candy newCandy, int index){
        candiesMass[index] = newCandy;
    }

    public void setCandy(Candy newCandy, int index){
        Candy[] temp = new Candy[candiesMass.length + 1];
        for (int i = 0; i < candiesMass.length; i++) {
            if (i < index) {
                temp[i] = candiesMass[i];
            } else {
                temp[i + 1] = candiesMass[i];
            }
        }
        temp[index] = newCandy;
        candiesMass = temp;
    }

    public double getPrice(int index){
        return candiesMass[index].getPrice();
    }

    public void add(Candy...newCandy) {
        for (Candy candy : newCandy){
            try{
                int index = candiesMass.length;
                Candy[] temp = new Candy[candiesMass.length + 1];
                for (int i = 0; i < candiesMass.length; i++) {
                    if (i < index) {
                        temp[i] = candiesMass[i];
                    } else {
                        temp[i + 1] = candiesMass[i];
                    }
                }
                temp[index] = candy;
                candiesMass = temp;
            } catch (NullPointerException e){
                candiesMass = new Candy[1];
                candiesMass[0] = candy;
            }

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Candy candy : candiesMass) {
            sb.append(candy.toString()).append("\n\n");
        }
        return sb.toString();
    }

}

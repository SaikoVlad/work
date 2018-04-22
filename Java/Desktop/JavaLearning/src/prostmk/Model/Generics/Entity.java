package prostmk.Model.Generics;

public class Entity {

    private String string;
    private int anInt;
    private double aDouble;

    public Entity(String string, int anInt, double aDouble) {
        this.string = string;
        this.anInt = anInt;
        this.aDouble = aDouble;
    }

    public Entity() {
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    @Override
    public String toString() {
        return String.format("\n%s\n%d\n%f",string,anInt,aDouble);
    }
}

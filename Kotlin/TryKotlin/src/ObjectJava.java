public class ObjectJava {

    private int integer;
    private String string;

    public ObjectJava(int integer, String string) {
        this.integer = integer;
        this.string = string;
    }


    @Override
    public String toString() {
        return "ObjectJava{" +
                "integer=" + integer +
                ", string='" + string + '\'' +
                '}';
    }
}

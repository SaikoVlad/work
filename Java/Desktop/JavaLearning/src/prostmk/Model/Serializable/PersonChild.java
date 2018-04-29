package prostmk.Model.Serializable;

import java.io.Serializable;

public class PersonChild extends Person implements Serializable{

    private Person parent;

    public PersonChild() {
    }

    public PersonChild(int age, String name, Person parent) {
        super(age, name, parent.getSurname());
        this.parent = parent;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return super.toString() + "\tParent: " + parent.toString();
    }
}

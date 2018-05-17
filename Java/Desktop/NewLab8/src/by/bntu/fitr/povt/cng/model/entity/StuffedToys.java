package by.bntu.fitr.povt.cng.model.entity;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

import java.io.Serializable;

public class StuffedToys extends Toy implements Serializable {
    private String person;
    private String gender;
    private int ageLimit;

    public StuffedToys() {
    }

    public StuffedToys(double price, double weight, double size, String person, String gender, int ageLimit) {

        super(price, weight, size);
        this.person = person;
        this.gender = gender;
        this.ageLimit = ageLimit;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\nStuffed Toys ").append(super.toString()).append("\n\tPerson: ").append(person).append("\n\tGender: ").append(gender).append("\n\tAge limit: ").append(ageLimit).toString();
    }
}

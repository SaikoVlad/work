package NewYearGift.Model.Entity;

import NewYearGift.Model.Entity.Abstract.Candy;

public class Chocolate extends Candy{


    private String type;
    private boolean withFilling;
    private String form;


    public Chocolate(double weight, String creator,double price, String type, boolean withFilling, String form) {
        super(weight, creator,price);
        this.type = type;
        this.withFilling = withFilling;
        this.form = form;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWithFilling() {
        return withFilling;
    }

    public void setWithFilling(boolean withFilling) {
        this.withFilling = withFilling;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Chocolate ").append(super.toString()).append("Type: ").append(type).append("\nWith filling? - ").append(withFilling).append("\nForm: ").append(form).toString();
    }
}

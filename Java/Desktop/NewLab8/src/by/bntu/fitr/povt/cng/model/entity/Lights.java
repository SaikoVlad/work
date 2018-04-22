package by.bntu.fitr.povt.cng.model.entity;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

public class Lights extends Toy {
    private int lifeTime;
    private int usualTemp;
    private int colorfulTemperature;

    public Lights() {

    }

    public Lights(double price, double weight, double size, int lifeTime, int usualTemp, int colorfulTemperature) {
        super(price, weight, size);
        this.lifeTime = lifeTime;
        this.usualTemp = usualTemp;
        this.colorfulTemperature = colorfulTemperature;
    }



    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public int getUsualTemp() {
        return usualTemp;
    }

    public void setUsualTemp(int usualTemp) {
        this.usualTemp = usualTemp;
    }

    public int getColorfulTemperature() {
        return colorfulTemperature;
    }

    public void setColorfulTemperature(int colorfulTemperature) {
        this.colorfulTemperature = colorfulTemperature;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\nLights "+ super.toString()).toString(); //+
//                "\n\tLife time: " + lifeTime +
//                "\n\tUsual temp: " + usualTemp +
//                "\n\tColorful temperature: " + colorfulTemperature).toString();
    }
}

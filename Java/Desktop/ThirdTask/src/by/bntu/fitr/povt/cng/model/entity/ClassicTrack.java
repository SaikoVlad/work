package by.bntu.fitr.povt.cng.model.entity;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Track;

public class ClassicTrack extends Track {

    private boolean soft;
    private int year;

    public ClassicTrack(){}

    public ClassicTrack(String name, String author, String genre, double length, double defeated, boolean soft, int year) {
        super(name, author, genre, length, defeated);
        this.soft = soft;
        this.year = year;
    }

    public boolean isSoft() {
        return soft;
    }

    public void setSoft(boolean soft) {
        this.soft = soft;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Classic").append(super.toString()).append("\nSoft: ").append(soft).append("\nYear: ").append(year).toString();
    }
}

package by.bntu.fitr.povt.cng.model.entity;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Track;

public class RapTrack extends Track {

    private int beat;
    private String cogenre;


    public RapTrack(){}

    public RapTrack(String name, String author, String genre, double length, double defeated, int beat, String cogenre) {
        super(name, author, genre, length, defeated);
        this.beat = beat;
        this.cogenre = cogenre;
    }


    public String getCogenre() {
        return cogenre;
    }

    public void setCogenre(String cogenre) {
        this.cogenre = cogenre;
    }

    public int getBeat() {
        return beat;

    }

    public void setBeat(int beat) {
        this.beat = beat;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Rap Track").append(super.toString()).append("\nBeat: ").append(beat).append("\nCo-genre: ").append(cogenre).append("\n").toString();
    }
}

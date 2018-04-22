package by.bntu.fitr.povt.cng.model.entity;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Track;

public class RockTrack extends Track {
    private String band;
    private int countOfPlayers;

    public RockTrack(){}

    public RockTrack(String name, String author, String genre, double length,double defeated ,String band, int countOfPlayers) {
        super(name, author, genre, length,defeated);
        this.band = band;
        this.countOfPlayers = countOfPlayers;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public int getCountOfPlayers() {
        return countOfPlayers;
    }

    public void setCountOfPlayers(int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("RockTrack" + super.toString() + "\nBand: " + band + "\nPlayers in band: " + countOfPlayers + "\n").toString();
    }
}

package by.bntu.fitr.povt.cng.model.entity.abstracts;

public class Track {
    private String name;
    private String author;
    private String genre;
    private double length;
    private double defeated;


    public Track() {
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getDefeated() {
        return defeated;
    }

    public void setDefeated(double defeated) {
        this.defeated = defeated;
    }

    public Track(String name, String author, String genre, double length, double defeated) {

        this.name = name;
        this.author = author;
        this.genre = genre;
        this.length = length;
        this.defeated = defeated;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(" Params:\nAuthor: ").append(author).append("\nTrack name: ").append(name).append("\nGenre:").append(genre).append("\nLength: ").append(length).append("\nDefeated: ").append(defeated).append("%").toString();
    }
}

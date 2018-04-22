package prostmk.Model.Enumeration;

public class Minsk implements City{

    private String country = "Belarus";
    private long people = 2_000_000;

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public long getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return "Minsk{" +
                "country='" + country + '\'' +
                ", people=" + people +
                '}';
    }
}

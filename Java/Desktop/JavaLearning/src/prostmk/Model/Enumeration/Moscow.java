package prostmk.Model.Enumeration;

public class Moscow implements City {

    private String country = "Russia";
    private long people = 11_920_000;

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public long getPeople() {
        return people;
    }
}

package prostmk.Model.Enumeration;

public class SanFrancisco implements City {

    private String country = "USA/California";
    private long people = 864_816;

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public long getPeople() {
        return people;
    }
}

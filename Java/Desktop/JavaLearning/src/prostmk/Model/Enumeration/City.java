package prostmk.Model.Enumeration;

public interface City {

    String country = null;
    long people = 0;

    String getCountry();
    long getPeople();

    @Override
    String toString();


}

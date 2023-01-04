public class City {
    private final String CITY_NAME;
    private final String GEOGRAPHIC_DISTRICT;
    private final String[] STREETS;

    //O(1)
    public City(String cityName, String geographicDistrict, String[] streets) {
        this.CITY_NAME = cityName;
        this.GEOGRAPHIC_DISTRICT = geographicDistrict;
        this.STREETS = streets;
    }

    //O(1)
    public String getCityName() {
        return CITY_NAME;
    }

    //O(1)
    public String getGeographicDistrict()
    {
        return GEOGRAPHIC_DISTRICT;
    }

    //O(1)
    public String[] getStreets() {
        return STREETS;
    }

    //O(1)
    public String toString()
    {
        return this.CITY_NAME +"-";
    }

}

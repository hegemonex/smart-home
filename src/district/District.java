package district;

public class District {

    private String districtName;
    private String city;
    private String country;
    private Street[] streets;

    public District(String districtName, String city, String country, Street[] streets) {
        this.districtName = districtName;
        this.city = city;
        this.country = country;
        this.streets = streets;
    }

    public String getDistrictName() { return districtName; }
    public void setDistrictName(String districtName) { this.districtName = districtName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Street[] getStreets() { return streets; }
    public void setStreets(Street[] streets) { this.streets = streets; }

    public String districtInfo() {
        return "District: " + districtName + " | City: " + city + " | Country: " + country
                + " | Streets: " + (streets != null ? streets.length : 0);
    }
}
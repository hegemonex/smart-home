package district;

import district.house.SmartHome;

public class Street {

    private String streetName;
    private String postalCode;
    private SmartHome[] homes;

    public Street(String streetName, String postalCode, SmartHome[] homes) {
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.homes = homes;
    }

    public String getStreetName() { return streetName; }
    public void setStreetName(String streetName) { this.streetName = streetName; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public SmartHome[] getHomes() { return homes; }
    public void setHomes(SmartHome[] homes) { this.homes = homes; }

    public String streetInfo() {
        return "Street: " + streetName + " | Postal Code: " + postalCode
                + " | Homes: " + (homes != null ? homes.length : 0);
    }
}
package district.house.devices;

public class DeviceZone {

    private String zoneName;
    private String location;
    private Device[] devices;

    public DeviceZone(String zoneName, String location, Device[] devices) {
        this.zoneName = zoneName;
        this.location = location;
        this.devices = devices;
    }

    public String getZoneName() { return zoneName; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Device[] getDevices() { return devices; }
    public void setDevices(Device[] devices) { this.devices = devices; }

    public String listDevices() {
        if (devices == null || devices.length == 0) {
            return "        Zone [" + zoneName + " - " + location + "]: no devices";
        }
        String result = "        Zone [" + zoneName + " - " + location + "]: ";
        for (int i = 0; i < devices.length; i++) {
            result += devices[i].getName();
            if (i < devices.length - 1) result += ", ";
        }
        return result;
    }
}
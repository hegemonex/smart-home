package district.house.devices;

public class DeviceGroup {

    private String groupName;
    private String category;
    private DeviceZone[] zones;

    public DeviceGroup(String groupName, String category, DeviceZone[] zones) {
        this.groupName = groupName;
        this.category = category;
        this.zones = zones;
    }

    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public DeviceZone[] getZones() { return zones; }
    public void setZones(DeviceZone[] zones) { this.zones = zones; }

    public String listZones() {
        if (zones == null || zones.length == 0) {
            return "      [" + category + "] " + groupName + ": no zones";
        }
        String result = "      [" + category + "] " + groupName + ":\n";
        for (DeviceZone zone : zones) {
            result += zone.listDevices() + "\n";
        }
        return result;
    }
}
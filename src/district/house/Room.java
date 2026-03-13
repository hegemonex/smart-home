package district.house;

import district.house.devices.DeviceGroup;

import java.math.BigDecimal;

public class Room {

    private String name;
    private BigDecimal area;
    private DeviceGroup[] deviceGroups;

    public Room(String name, BigDecimal area, DeviceGroup[] deviceGroups) {
        this.name = name;
        this.area = area;
        this.deviceGroups = deviceGroups;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getArea() { return area; }
    public void setArea(BigDecimal area) { this.area = area; }

    public DeviceGroup[] getDeviceGroups() { return deviceGroups; }
    public void setDeviceGroups(DeviceGroup[] deviceGroups) { this.deviceGroups = deviceGroups; }

    public String listGroups() {
        if (deviceGroups == null || deviceGroups.length == 0) {
            return "    Room: " + name + " — no device groups";
        }
        String result = "    Room: " + name + " (" + area + " sqm)\n";
        for (DeviceGroup group : deviceGroups) {
            result += group.listZones();
        }
        return result;
    }
}
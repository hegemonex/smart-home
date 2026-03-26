package district.house.devices;

import java.util.HashMap;
import java.util.Map;

public class DeviceZone {

    private String zoneName;
    private String location;
    private Map<Device, String> devicePlacementMap;

    public DeviceZone(String zoneName, String location) {
        this.zoneName = zoneName;
        this.location = location;
        this.devicePlacementMap = new HashMap<>();
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<Device, String> getDevicePlacementMap() {
        return devicePlacementMap;
    }

    public void addDevice(Device device, String placement) {
        devicePlacementMap.put(device, placement);
    }

    public void removeDevice(Device device) {
        devicePlacementMap.remove(device);
    }

    public String listDevices() {
        if (devicePlacementMap.isEmpty()) {
            return "Zone [" + zoneName + " - " + location + "]: no devices";
        }

        StringBuilder result = new StringBuilder();
        result.append("Zone [")
                .append(zoneName)
                .append(" - ")
                .append(location)
                .append("]: ");

        int count = 0;
        for (Map.Entry<Device, String> entry : devicePlacementMap.entrySet()) {
            if (count > 0) {
                result.append(", ");
            }

            result.append(entry.getKey().getName())
                    .append(" [")
                    .append(entry.getValue())
                    .append("]");

            count++;
        }

        return result.toString();
    }
}
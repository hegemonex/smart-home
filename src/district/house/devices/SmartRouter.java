package district.house.devices;


import java.math.BigDecimal;
import java.time.LocalDate;

public class SmartRouter extends Device {

    private String ssid;
    private int connectedDevicesCount;
    private double bandwidthGbps;

    public SmartRouter(String name, BigDecimal price, LocalDate installedDate,
                       String ssid, int connectedDevicesCount, double bandwidthGbps) {
        super(name, price, installedDate);
        this.ssid = ssid;
        this.connectedDevicesCount = connectedDevicesCount;
        this.bandwidthGbps = bandwidthGbps;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public int getConnectedDevicesCount() {
        return connectedDevicesCount;
    }

    public void setConnectedDevicesCount(int connectedDevicesCount) {
        this.connectedDevicesCount = connectedDevicesCount;
    }

    public double getBandwidthGbps() {
        return bandwidthGbps;
    }

    public void setBandwidthGbps(double bandwidthGbps) {
        this.bandwidthGbps = bandwidthGbps;
    }

    @Override
    public String deviceInfo() {
        return super.deviceInfo() + " | SSID: " + ssid + ", Connected: " + connectedDevicesCount
                + " devices, Bandwidth: " + bandwidthGbps + " Gbps";
    }

    public String showNetworkStatus() {
        return getName() + ": broadcasting '" + ssid + "' with " + connectedDevicesCount + " device(s) connected.";
    }

    public String reboot() {
        return getName() + " is rebooting... Network will resume shortly.";
    }
}
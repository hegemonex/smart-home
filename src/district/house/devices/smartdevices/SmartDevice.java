package district.house.devices.smartdevices;

import district.house.devices.Device;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class SmartDevice extends Device {

    protected boolean connectedToWifi;

    public SmartDevice(String name, BigDecimal price, LocalDate installedDate, boolean connectedToWifi) {
        super(name, price, installedDate);
        this.connectedToWifi = connectedToWifi;
    }

    public boolean isConnectedToWifi() {
        return connectedToWifi;
    }

    public void setConnectedToWifi(boolean connectedToWifi) {
        this.connectedToWifi = connectedToWifi;
    }

    @Override
    public void operate() {
        System.out.println(name + " is operating through the smart network.");
    }
}
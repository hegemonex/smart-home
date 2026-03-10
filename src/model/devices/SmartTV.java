package model.devices;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SmartTV extends Device {

    private String brand;
    private int screenSize;
    private boolean isOn;

    public SmartTV(String name, BigDecimal price, LocalDate installedDate, String brand, int screenSize) {
        super(name, price, installedDate);
        this.brand = brand;
        this.screenSize = screenSize;
        this.isOn = false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String deviceInfo() {
        return super.deviceInfo() + " | Brand: " + brand + ", Screen: " + screenSize + " inches";
    }

    public String turnOn() {
        isOn = true;
        return brand + " TV is now ON.";
    }

    public String turnOff() {
        isOn = false;
        return brand + " TV is now OFF.";
    }
}

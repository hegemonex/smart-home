package district.house.devices.smartDevices;

import district.house.devices.Device;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SmartLight extends SmartDevice {

    private String color;
    private String model;
    private int brightness;

    public SmartLight(String name, BigDecimal price, LocalDate installedDate, String color,
                      String model, int brightness, boolean connected) {
        super(name, price, installedDate, connected);
        this.color = color;
        this.model = model;
        this.brightness = brightness;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public String deviceInfo() {
        return super.deviceInfo() + " | Model: " + model + ", Color: " + color + ", Brightness: " + brightness + "%";
    }

    public String turnOn() {
        return getName() + " light is ON at " + brightness + "% brightness.";
    }

    public String turnOff() {
        return getName() + " light is OFF.";
    }

    @Override
    public void operate() {
        System.out.println(name + " is lighting");
    }

}
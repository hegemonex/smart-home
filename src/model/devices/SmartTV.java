package model.devices;

public class SmartTV extends Device {
    private String brand;
    private int screenSize;
    private boolean isOn;

    public SmartTV(String brand, int screenSize) {
        this.brand = brand;
        this.screenSize = screenSize;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getScreenSize() { return screenSize; }
    public void setScreenSize(int screenSize) { this.screenSize = screenSize; }

    public boolean isOn() { return isOn; }
    public void setOn(boolean on) { isOn = on; }

    @Override
    public String deviceInfo() {
        return super.deviceInfo() + " it is a " + screenSize
                + " inch " + brand + " TV";
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

package model.devices;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Thermostat extends Device {

    private double currentTemp;
    private double targetTemp;

    public Thermostat(String name, BigDecimal price, LocalDate installedDate, double currentTemp, double targetTemp) {
        super(name, price, installedDate);
        this.currentTemp = currentTemp;
        this.targetTemp = targetTemp;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public double getTargetTemp() {
        return targetTemp;
    }

    public void setTargetTemp(double targetTemp) {
        this.targetTemp = targetTemp;
    }

    @Override
    public String deviceInfo() {
        return super.deviceInfo() + " | Current: " + currentTemp + "°C, Target: " + targetTemp + "°C";
    }

    public String adjustTemp() {
        return getName() + ": adjusting from " + currentTemp + "°C to target " + targetTemp + "°C.";
    }
}

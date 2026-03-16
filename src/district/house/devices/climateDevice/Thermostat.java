package district.house.devices.climateDevice;

import district.house.devices.Device;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Thermostat extends ClimateDevice {

    private double currentTemp;
    private double targetTemp;

    public Thermostat(String name, BigDecimal price, LocalDate installedDate, double currentTemp, double targetTemp, Double maximumTemp) {
        super(name, price, installedDate, maximumTemp);
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

    @Override
    public void operate() {
        System.out.println(name + " is thermostating");
    }

}

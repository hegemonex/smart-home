package district.house.devices.climatedevice;

import district.house.devices.Device;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class ClimateDevice extends Device {

    protected double temperatureSetting;

    public ClimateDevice(String name, BigDecimal price, LocalDate installedDate, double temperatureSetting) {
        super(name, price, installedDate);
        this.temperatureSetting = temperatureSetting;
    }

    public double getTemperatureSetting() {
        return temperatureSetting;
    }

    public void setTemperatureSetting(double temperatureSetting) {
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void operate() {
        System.out.println(name + " is controlling temperature at " + temperatureSetting + "°C");
    }
}
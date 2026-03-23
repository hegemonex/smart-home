package district.house.devices.sensors;

import district.house.devices.Device;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Sensor extends Device {

    protected double sensorValue;

    public Sensor(String name, BigDecimal price, LocalDate installedDate, double sensorValue) {
        super(name, price, installedDate);
        this.sensorValue = sensorValue;
    }

    public Sensor(){}

    public double getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(double sensorValue) {
        this.sensorValue = sensorValue;
    }

    @Override
    public void operate() {
        System.out.println(name + " is detecting something. Current value: " + sensorValue);
    }
}
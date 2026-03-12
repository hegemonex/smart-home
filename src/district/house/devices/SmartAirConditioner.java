package district.house.devices;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SmartAirConditioner extends Device {

    private String mode;
    private double temperature;
    private int fanSpeed;

    public SmartAirConditioner(String name, BigDecimal price, LocalDate installedDate,
                               String mode, double temperature, int fanSpeed) {
        super(name, price, installedDate);
        this.mode = mode;
        this.temperature = temperature;
        this.fanSpeed = fanSpeed;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    @Override
    public String deviceInfo() {
        return super.deviceInfo() + " | Mode: " + mode + ", Temp: " + temperature + "°C, Fan: " + fanSpeed;
    }

    public String turnOn() {
        return getName() + " AC ON — Mode: " + mode + ", Temp: " + temperature + "°C, Fan speed: " + fanSpeed;
    }

    public String turnOff() {
        return getName() + " AC is OFF.";
    }

    public String changeMode(String newMode) {
        this.mode = newMode;
        return getName() + " AC mode changed to " + mode;
    }
}
package district.house.devices;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Device {

    protected static int deviceCount = 0;   // protected #1

    protected String name;                  // protected #2
    protected BigDecimal price;
    protected LocalDate installedDate;

    public Device(String name, BigDecimal price, LocalDate installedDate) {
        this.name = name;
        this.price = price;
        this.installedDate = installedDate;
        deviceCount++;
    }

    public static int getDeviceCount() {
        return deviceCount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getInstalledDate() {
        return installedDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setInstalledDate(LocalDate installedDate) {
        this.installedDate = installedDate;
    }

    public String deviceInfo() {
        return name + " (installed: " + installedDate + ", price: $" + price + ")";
    }

    // ABSTRACT METHOD (must be overridden)
    public abstract void operate();

    // OBJECT METHOD OVERRIDES

    @Override
    public String toString() {
        return "Device{name='" + name + "', price=" + price + ", installedDate=" + installedDate + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, installedDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Device)) return false;
        Device other = (Device) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(price, other.price) &&
                Objects.equals(installedDate, other.installedDate);
    }
}
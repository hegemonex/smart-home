package model.devices;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Device {

    private static int deviceCount = 0;

    private String name;
    private BigDecimal price;
    private LocalDate installedDate;

    public Device(String name, BigDecimal price, LocalDate installedDate) {
        this.name = name;
        this.price = price;
        this.installedDate = installedDate;
        deviceCount++;
    }

    public static int getDeviceCount() {
        return deviceCount;
    }

    public static void setDeviceCount(int deviceCount) {
        Device.deviceCount = deviceCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getInstalledDate() {
        return installedDate;
    }

    public void setInstalledDate(LocalDate installedDate) {
        this.installedDate = installedDate;
    }

    public String deviceInfo() {
        return name + " (installed: " + installedDate + ", price: $" + price + ")";
    }
}

package district.house.rooms;

import district.house.devices.DeviceGroup;

import java.math.BigDecimal;

public class Garage extends Room {

    private int carCapacity;

    public Garage(String name, BigDecimal area, DeviceGroup[] groups, int carCapacity) {
        super(name, area, groups);
        this.carCapacity = carCapacity;
    }

    public int getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(int carCapacity) {
        this.carCapacity = carCapacity;
    }

    @Override
    public String listGroups() {
        return super.listGroups() + "      Garage capacity: " + carCapacity + " cars\n";
    }
}
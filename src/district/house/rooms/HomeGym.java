package district.house.rooms;

import district.house.devices.DeviceGroup;

import java.math.BigDecimal;

public class HomeGym extends Room {

    private int equipmentCount;

    public HomeGym(String name, BigDecimal area, DeviceGroup[] groups, int equipmentCount) {
        super(name, area, groups);
        this.equipmentCount = equipmentCount;
    }

    public int getEquipmentCount() {
        return equipmentCount;
    }

    public void setEquipmentCount(int equipmentCount) {
        this.equipmentCount = equipmentCount;
    }
}
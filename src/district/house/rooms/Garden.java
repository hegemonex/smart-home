package district.house.rooms;

import java.math.BigDecimal;
import district.house.devices.DeviceGroup;;

public class Garden extends Room {

    private boolean hasIrrigation;

    public Garden(String name, BigDecimal area, DeviceGroup[] groups, boolean hasIrrigation) {
        super(name, area, groups);
        this.hasIrrigation = hasIrrigation;
    }

    public boolean isHasIrrigation() {
        return hasIrrigation;
    }

    public void setHasIrrigation(boolean hasIrrigation) {
        this.hasIrrigation = hasIrrigation;
    }
}
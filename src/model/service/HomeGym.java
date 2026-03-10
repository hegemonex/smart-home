package model.service;

import java.math.BigDecimal;

public class HomeGym {

    private BigDecimal area;
    private int equipmentCount;
    private boolean hasMirrors;
    private String flooring;

    public HomeGym(BigDecimal area, int equipmentCount, boolean hasMirrors, String flooring) {
        this.area = area;
        this.equipmentCount = equipmentCount;
        this.hasMirrors = hasMirrors;
        this.flooring = flooring;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public int getEquipmentCount() {
        return equipmentCount;
    }

    public void setEquipmentCount(int equipmentCount) {
        this.equipmentCount = equipmentCount;
    }

    public boolean isHasMirrors() {
        return hasMirrors;
    }

    public void setHasMirrors(boolean hasMirrors) {
        this.hasMirrors = hasMirrors;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public String gymInfo() {
        return "Home Gym | Area: " + area + " sqm | Equipment: " + equipmentCount
                + " pieces | Mirrors: " + hasMirrors + " | Flooring: " + flooring;
    }
}
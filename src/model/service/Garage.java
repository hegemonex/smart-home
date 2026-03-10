package model.service;

import java.math.BigDecimal;

public class Garage {

    private int capacity;
    private boolean hasSmartDoor;
    private BigDecimal area;
    private boolean isLocked;

    public Garage(int capacity, boolean hasSmartDoor, BigDecimal area, boolean isLocked) {
        this.capacity = capacity;
        this.hasSmartDoor = hasSmartDoor;
        this.area = area;
        this.isLocked = isLocked;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasSmartDoor() {
        return hasSmartDoor;
    }

    public void setHasSmartDoor(boolean hasSmartDoor) {
        this.hasSmartDoor = hasSmartDoor;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String garageInfo() {
        return "Garage | Capacity: " + capacity + " cars | Area: " + area + " sqm"
                + " | Smart Door: " + hasSmartDoor + " | Locked: " + isLocked;
    }
}
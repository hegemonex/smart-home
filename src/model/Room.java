package model;

import model.devices.Device;

public class Room {

    private String name;
    private int floor;
    private Device[] devices;

    public Room(String name, int floor, Device[] devices) {
        this.name = name;
        this.floor = floor;
        this.devices = devices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Device[] getDevices() {
        return devices;
    }

    public void setDevices(Device[] devices) {
        this.devices = devices;
    }

    public String listDevices() {
        if (devices == null || devices.length == 0) {
            return name + " has no devices.";
        }
        String result = "Devices in " + name + " (floor " + floor + "): ";
        for (int i = 0; i < devices.length; i++) {
            result += devices[i].getName();
            if (i < devices.length - 1) {
                result += ", ";
            }
        }
        return result;
    }
}
package model;

import model.devices.Device;

import java.time.LocalDate;

public class SmartHome {

    private static int totalHomes = 0;
    private static final String SYSTEM_VERSION = "2.0";

    static {
        System.out.println("SmartHome system initialized. Version: " + SYSTEM_VERSION);
    }

    private String name;
    private String address;
    private LocalDate builtDate;
    private Room[] rooms;

    public SmartHome(String name, String address, LocalDate builtDate, Room[] rooms) {
        this.name = name;
        this.address = address;
        this.builtDate = builtDate;
        this.rooms = rooms;
        totalHomes++;
    }

    public static int getTotalHomes() {
        return totalHomes;
    }

    public static void setTotalHomes(int totalHomes) {
        SmartHome.totalHomes = totalHomes;
    }

    public static String getSystemVersion() {
        return SYSTEM_VERSION;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBuiltDate() {
        return builtDate;
    }

    public void setBuiltDate(LocalDate builtDate) {
        this.builtDate = builtDate;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public String listAllDevices() {
        if (rooms == null || rooms.length == 0) {
            return name + " has no rooms set up yet.";
        }
        String result = "All devices in " + name + " (" + address + "):\n";
        for (Room room : rooms) {
            result += "  " + room.listDevices() + "\n";
        }
        return result;
    }
}
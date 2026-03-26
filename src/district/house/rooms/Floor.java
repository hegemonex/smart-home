package district.house.rooms;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private int floorNumber;
    private String label;
    private List<Room> rooms;

    public Floor(int floorNumber, String label, List<Room> rooms) {
        this.rooms = rooms != null ? new ArrayList<>(rooms) : new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public boolean removeRoom(Room room) {
        return rooms.remove(room);
    }

    public boolean isEmpty() {
        return rooms.isEmpty();
    }

    public int size() {
        return rooms.size();
    }

    public Room getFirstRoom() {
        return rooms.isEmpty() ? null : rooms.get(0);
    }

    public String listRooms() {
        if (rooms == null || rooms.isEmpty()) {
            return "  Floor " + floorNumber + " (" + label + "): no rooms";
        }
        String result = "  Floor " + floorNumber + " — " + label + ":\n";
        for (Room room : rooms) {
            result += room.listGroups();
        }
        return result;
    }
}
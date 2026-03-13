package district.house;

public class Floor {

    private int floorNumber;
    private String label;
    private Room[] rooms;

    public Floor(int floorNumber, String label, Room[] rooms) {
        this.floorNumber = floorNumber;
        this.label = label;
        this.rooms = rooms;
    }

    public int getFloorNumber() { return floorNumber; }
    public void setFloorNumber(int floorNumber) { this.floorNumber = floorNumber; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public Room[] getRooms() { return rooms; }
    public void setRooms(Room[] rooms) { this.rooms = rooms; }

    public String listRooms() {
        if (rooms == null || rooms.length == 0) {
            return "  Floor " + floorNumber + " (" + label + "): no rooms";
        }
        String result = "  Floor " + floorNumber + " — " + label + ":\n";
        for (Room room : rooms) {
            result += room.listGroups();
        }
        return result;
    }
}
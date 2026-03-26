package district.house;

import district.Neighbourhood;
import district.NetworkProvider;
import district.SecurityCompany;
import district.SewerageSystem;
import district.house.rooms.Floor;
import district.house.rooms.Garage;
import district.house.rooms.Garden;
import district.house.rooms.HomeGym;
import util.Pair;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmartHome {

    private static int totalHomes = 0;
    private static final String SYSTEM_VERSION = "2.0";

    static {
        System.out.println("SmartHome system initialized. Version: " + SYSTEM_VERSION);
    }

    private String name;
    private LocalDate builtDate;
    private Neighbourhood neighbourhood;
    private NetworkProvider networkProvider;
    private SecurityCompany securityCompany;
    private SolarPanel solarPanel;
    private SewerageSystem sewerageSystem;
    private Garage garage;
    private Garden garden;
    private HomeGym homeGym;
    private Set<Owner> owners;
    private List<Floor> floors;

    public SmartHome(String name, LocalDate builtDate, Owner primaryOwner,
                     Neighbourhood neighbourhood, NetworkProvider networkProvider,
                     SecurityCompany securityCompany, SolarPanel solarPanel,
                     SewerageSystem sewerageSystem, Garage garage,
                     Garden garden, HomeGym homeGym, List<Floor> floors) {

        this.name = name;
        this.builtDate = builtDate;
        this.neighbourhood = neighbourhood;
        this.networkProvider = networkProvider;
        this.securityCompany = securityCompany;
        this.solarPanel = solarPanel;
        this.sewerageSystem = sewerageSystem;
        this.garage = garage;
        this.garden = garden;
        this.homeGym = homeGym;

        this.owners = new HashSet<>();
        if (primaryOwner != null) {
            this.owners.add(primaryOwner);
        }

        this.floors = floors != null ? new ArrayList<>(floors) : new ArrayList<>();

        totalHomes++;
    }

    public static int getTotalHomes() {
        return totalHomes;
    }

    public static String getSystemVersion() {
        return SYSTEM_VERSION;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBuiltDate() {
        return builtDate;
    }

    public void addOwner(Owner owner) {
        if (owner != null) {
            owners.add(owner);
        }
    }

    public boolean removeOwner(Owner owner) {
        return owners.remove(owner);
    }

    public Owner getPrimaryOwner() {
        return owners.isEmpty() ? null : owners.iterator().next();
    }

    public String listAllDevices() {
        if (floors.isEmpty()) {
            return name + " has no floors set up yet.";
        }

        StringBuilder result = new StringBuilder();

        result.append("=== ")
                .append(name)
                .append(" (built: ")
                .append(builtDate)
                .append(") ===\n");

        result.append("Owners:\n");
        for (Owner o : owners) {
            result.append("  - ")
                    .append(o.ownerInfo())
                    .append("\n");
        }

        result.append("\nDevices:\n");

        for (Floor floor : floors) {
            result.append(floor.listRooms())
                    .append("\n");
        }

        return result.toString();
    }

    public Pair<String, String> getHomeOwnerSummary() {
        Owner primary = getPrimaryOwner();
        return new Pair<>(name, primary != null ? primary.getName() : "Unknown");
    }
}
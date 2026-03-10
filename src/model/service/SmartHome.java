package model.service;

import java.time.LocalDate;

public class SmartHome {

    private static int totalHomes = 0;
    private static final String SYSTEM_VERSION = "2.0";

    static {
        System.out.println("SmartHome system initialized. Version: " + SYSTEM_VERSION);
    }

    private String name;
    private LocalDate builtDate;
    private Owner owner;
    private Neighbourhood neighbourhood;
    private NetworkProvider networkProvider;
    private SecurityCompany securityCompany;
    private SolarPanel solarPanel;
    private SewageSystem sewageSystem;
    private Garage garage;
    private Garden garden;
    private HomeGym homeGym;
    private Room[] rooms;

    public SmartHome(String name, LocalDate builtDate, Owner owner, Neighbourhood neighbourhood,
                     NetworkProvider networkProvider, SecurityCompany securityCompany,
                     SolarPanel solarPanel, SewageSystem sewageSystem,
                     Garage garage, Garden garden, HomeGym homeGym, Room[] rooms) {
        this.name = name;
        this.builtDate = builtDate;
        this.owner = owner;
        this.neighbourhood = neighbourhood;
        this.networkProvider = networkProvider;
        this.securityCompany = securityCompany;
        this.solarPanel = solarPanel;
        this.sewageSystem = sewageSystem;
        this.garage = garage;
        this.garden = garden;
        this.homeGym = homeGym;
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

    public LocalDate getBuiltDate() {
        return builtDate;
    }

    public void setBuiltDate(LocalDate builtDate) {
        this.builtDate = builtDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Neighbourhood getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(Neighbourhood neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public NetworkProvider getNetworkProvider() {
        return networkProvider;
    }

    public void setNetworkProvider(NetworkProvider networkProvider) {
        this.networkProvider = networkProvider;
    }

    public SecurityCompany getSecurityCompany() {
        return securityCompany;
    }

    public void setSecurityCompany(SecurityCompany securityCompany) {
        this.securityCompany = securityCompany;
    }

    public SolarPanel getSolarPanel() {
        return solarPanel;
    }

    public void setSolarPanel(SolarPanel solarPanel) {
        this.solarPanel = solarPanel;
    }

    public SewageSystem getSewageSystem() {
        return sewageSystem;
    }

    public void setSewerageSystem(SewageSystem sewageSystem) {
        this.sewageSystem = sewageSystem;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }

    public HomeGym getHomeGym() {
        return homeGym;
    }

    public void setHomeGym(HomeGym homeGym) {
        this.homeGym = homeGym;
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
        String result = "All devices in " + name + ":\n";
        for (Room room : rooms) {
            result += "  " + room.listDevices() + "\n";
        }
        return result;
    }
}
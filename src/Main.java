import model.devices.*;
import model.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // --- Owner ---
        Owner owner = new Owner(
                "John Smith", "john@example.com", "+1-555-9999",
                LocalDate.of(2022, 5, 1)
        );

        // --- Neighbourhood ---
        Neighbourhood neighbourhood = new Neighbourhood(
                "Maple Grove", "Springfield", 120, true
        );

        // --- Network Provider ---
        NetworkProvider networkProvider = new NetworkProvider(
                "SpeedNet ISP", new BigDecimal("59.99"), 500, "Fiber"
        );

        // --- Security Company ---
        SecurityCompany securityCompany = new SecurityCompany(
                "ShieldGuard Security", "+1-555-0911", new BigDecimal("39.99"), true
        );

        // --- Solar Panel ---
        SolarPanel solarPanel = new SolarPanel(
                "SunPower", new BigDecimal("8.50"), 12, LocalDate.of(2022, 7, 15)
        );

        // --- Sewage System ---
        SewageSystem sewerageSystem = new SewageSystem(
                "City Sewerage Co.", true, LocalDate.of(2024, 9, 10), "PVC"
        );

        // --- Garage ---
        Garage garage = new Garage(2, true, new BigDecimal("45.00"), true);

        // --- Garden ---
        Garden garden = new Garden(new BigDecimal("120.00"), "English", true, 8);

        // --- Home Gym ---
        HomeGym homeGym = new HomeGym(new BigDecimal("30.00"), 10, true, "Rubber");

        // --- Living Room devices ---
        SmartLight livingRoomLight = new SmartLight(
                "Living Room Light", new BigDecimal("49.99"), LocalDate.of(2024, 3, 10),
                "Warm White", "Philips Hue", 80
        );
        SmartTV livingRoomTV = new SmartTV(
                "Living Room TV", new BigDecimal("799.99"), LocalDate.of(2023, 11, 20),
                "Samsung", 55
        );
        SmartSpeaker livingRoomSpeaker = new SmartSpeaker(
                "Living Room Speaker", new BigDecimal("129.99"), LocalDate.of(2024, 1, 5),
                "Alexa", 5, 20
        );
        Thermostat livingRoomThermostat = new Thermostat(
                "Living Room Thermostat", new BigDecimal("89.99"), LocalDate.of(2023, 12, 1),
                22.0, 24.0
        );
        SmartAirConditioner livingRoomAC = new SmartAirConditioner(
                "Living Room AC", new BigDecimal("349.99"), LocalDate.of(2023, 6, 15),
                "Cool", 21.0, 3
        );

        // --- Hallway devices ---
        MotionSensor hallwaySensor = new MotionSensor(
                "Hallway Motion Sensor", new BigDecimal("39.99"), LocalDate.of(2024, 2, 14),
                7, 10
        );
        SmartDoorLock mainDoorLock = new SmartDoorLock(
                "Main Door Lock", new BigDecimal("199.99"), LocalDate.of(2024, 1, 20),
                "Yale Assure"
        );
        SecurityCamera frontDoorCamera = new SecurityCamera(
                "Front Door Camera", new BigDecimal("149.99"), LocalDate.of(2024, 2, 1),
                "4K", "Infrared"
        );

        // --- Kitchen devices ---
        SmartLight kitchenLight = new SmartLight(
                "Kitchen Light", new BigDecimal("34.99"), LocalDate.of(2024, 3, 10),
                "Cool White", "Ikea Tradfri", 100
        );
        SmartPlug coffeeMachinePlug = new SmartPlug(
                "Coffee Machine Plug", new BigDecimal("24.99"), LocalDate.of(2024, 3, 5),
                "Coffee Machine", new BigDecimal("1200.00")
        );

        // --- Office devices ---
        SmartRouter officeRouter = new SmartRouter(
                "Office Router", new BigDecimal("189.99"), LocalDate.of(2023, 10, 10),
                "MySmartHome_5G", 12, 2.4
        );

        // --- Rooms ---
        Device[] livingRoomDevices = {livingRoomLight, livingRoomTV, livingRoomSpeaker, livingRoomThermostat, livingRoomAC};
        Device[] hallwayDevices = {hallwaySensor, mainDoorLock, frontDoorCamera};
        Device[] kitchenDevices = {kitchenLight, coffeeMachinePlug};
        Device[] officeDevices = {officeRouter};

        Room livingRoom = new Room("Living Room", 1, livingRoomDevices);
        Room hallway = new Room("Hallway", 1, hallwayDevices);
        Room kitchen = new Room("Kitchen", 1, kitchenDevices);
        Room office = new Room("Office", 2, officeDevices);

        // --- Root object: SmartHome fully populated ---
        SmartHome myHome = new SmartHome(
                "My Smart Home",
                LocalDate.of(2023, 6, 1),
                owner,
                neighbourhood,
                networkProvider,
                securityCompany,
                solarPanel,
                sewerageSystem,
                garage,
                garden,
                homeGym,
                new Room[]{livingRoom, hallway, kitchen, office}
        );

        // --- Output ---
        System.out.println(myHome.listAllDevices());
        System.out.println(myHome.getOwner().ownerInfo());
        System.out.println(myHome.getNeighbourhood().neighbourhoodInfo());
        System.out.println(myHome.getNetworkProvider().networkInfo());
        System.out.println(myHome.getSecurityCompany().securityInfo());
        System.out.println(myHome.getSolarPanel().solarInfo());
        System.out.println(myHome.getSewageSystem().sewageInfo());
        System.out.println(myHome.getGarage().garageInfo());
        System.out.println(myHome.getGarden().gardenInfo());
        System.out.println(myHome.getHomeGym().gymInfo());


        System.out.println("Total smart homes: " + SmartHome.getTotalHomes());
        System.out.println("Total devices created: " + Device.getDeviceCount());
    }
}
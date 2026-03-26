import district.*;
import district.house.Owner;
import district.house.SmartHome;
import district.house.SmartHomeLogger;
import district.house.SolarPanel;
import district.house.devices.Connectable;
import district.house.devices.Device;
import district.house.devices.DeviceGroup;
import district.house.devices.DeviceZone;
import district.house.devices.climatedevice.SmartAirConditioner;
import district.house.devices.climatedevice.Thermostat;
import district.house.devices.sensors.MotionSensor;
import district.house.devices.sensors.SecurityCamera;
import district.house.devices.smartdevices.*;
import district.house.rooms.*;
import exceptions.DeviceInstallationException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    @SafeVarargs
    private static <T> List<T> list(T... items) {
        List<T> result = new ArrayList<>();
        for (T item : items) result.add(item);
        return result;
    }

    public static void main(String[] args) {

        List<DeviceGroup> deviceGroups = new ArrayList<>();

        // --- Devices ---
        SmartLight ceilingLight = new SmartLight("Ceiling Light", new BigDecimal("49.99"), LocalDate.of(2024, 3, 10), "Warm White", "Philips Hue", 80, true);

        SmartLight floorLamp = new SmartLight("Floor Lamp", new BigDecimal("29.99"), LocalDate.of(2024, 3, 10), "Soft White", "Ikea Tradfri", 60, true);

        SmartTV livingRoomTV = new SmartTV("Living Room TV", new BigDecimal("799.99"), LocalDate.of(2023, 11, 20), "Samsung", 55, true);

        SmartSpeaker livingRoomSpeaker = new SmartSpeaker("Living Room Speaker", new BigDecimal("129.99"), LocalDate.of(2024, 1, 5), "Alexa", 5, 20, true);

        Thermostat livingRoomThermostat = new Thermostat("Living Room Thermostat", new BigDecimal("89.99"), LocalDate.of(2023, 12, 1), 22.0, 24.0, 100.0);

        SmartAirConditioner livingRoomAC = new SmartAirConditioner("Living Room AC", new BigDecimal("349.99"), LocalDate.of(2023, 6, 15), "Cool", 21.0, 3, 26.7);

        MotionSensor hallwaySensor = new MotionSensor("Hallway Motion Sensor", new BigDecimal("39.99"), LocalDate.of(2024, 2, 14), 7, 10, 67.8, "Super sensitive");

        SmartDoorLock mainDoorLock = new SmartDoorLock("Main Door Lock", new BigDecimal("199.99"), LocalDate.of(2024, 1, 20), "Yale Assure");

        SecurityCamera frontDoorCamera = new SecurityCamera("Front Door Camera", new BigDecimal("149.99"), LocalDate.of(2024, 2, 1), "4K", "Infrared", 56.4);

        SmartPlug coffeeMachinePlug = new SmartPlug("Coffee Machine Plug", new BigDecimal("24.99"), LocalDate.of(2024, 3, 5), "Coffee Machine", new BigDecimal("1200.00"), false);

        SmartRouter officeRouter = new SmartRouter("Office Router", new BigDecimal("189.99"), LocalDate.of(2023, 10, 10), "MySmartHome_5G", 12, 2.4, false);

        // --- Standalone Classes ---
        Owner owner = new Owner("John Smith", "john@example.com", "+1-555-9999", LocalDate.of(2022, 5, 1));

        Neighbourhood neighbourhood = new Neighbourhood("Maple Grove", "Springfield", 120, true);

        NetworkProvider networkProvider = new NetworkProvider("SpeedNet ISP", new BigDecimal("59.99"), 500, "Fiber");

        SecurityCompany securityCompany = new SecurityCompany("ShieldGuard", "+1-555-0911", new BigDecimal("39.99"), true);

        SolarPanel solarPanel = new SolarPanel("SunPower", new BigDecimal("8.50"), 12, LocalDate.of(2022, 7, 15));

        SewerageSystem sewerageSystem = new SewerageSystem("City Sewerage Co.", true, LocalDate.of(2024, 9, 10), "PVC");

        // --- Rooms extending Room ---
        Garage garage = new Garage("Garage", new BigDecimal("50.0"), deviceGroups, 2);

        Garden garden = new Garden("Garden", new BigDecimal("120.00"), deviceGroups, true);

        HomeGym homeGym = new HomeGym("Home Gym", new BigDecimal("30.00"), deviceGroups, 10);

        // --- Device Zones ---
        DeviceZone northLighting = new DeviceZone("North Lighting", "North Wall");

        DeviceZone southLighting = new DeviceZone("South Lighting", "South Corner");

        DeviceZone mainEntertainment = new DeviceZone("Main Entertainment", "East Wall");

        DeviceZone climateControl = new DeviceZone("Climate Control", "Central");

        DeviceZone entrySecurity = new DeviceZone("Entry Security", "Front Door");

        DeviceZone motionDetection = new DeviceZone("Motion Detection", "Ceiling");

        DeviceZone kitchenAppliances = new DeviceZone("Appliances", "Counter");

        DeviceZone networkZone = new DeviceZone("Network", "Desk");

        // --- Device Groups ---
        DeviceGroup livingLighting = new DeviceGroup("Living Lighting", "Lighting", list(northLighting, southLighting));

        DeviceGroup livingEntertainment = new DeviceGroup("Entertainment", "Entertainment", list(mainEntertainment));

        DeviceGroup livingClimate = new DeviceGroup("Climate", "Climate", list(climateControl));

        DeviceGroup hallwaySecurity = new DeviceGroup("Security", "Security", list(entrySecurity, motionDetection));

        DeviceGroup kitchenGroup = new DeviceGroup("Kitchen Devices", "Appliances", list(kitchenAppliances));

        DeviceGroup officeNetwork = new DeviceGroup("Network", "Network", list(networkZone));

        // --- Rooms ---
        Room livingRoom = new Room("Living Room", new BigDecimal("35.00"), list(livingLighting, livingEntertainment, livingClimate));

        Room hallway = new Room("Hallway", new BigDecimal("12.00"), list(hallwaySecurity));

        Room kitchen = new Room("Kitchen", new BigDecimal("20.00"), list(kitchenGroup));

        Room office = new Room("Office", new BigDecimal("18.00"), list(officeNetwork));

        // --- Floors ---
        Floor groundFloor = new Floor(1, "Ground Floor", list(livingRoom, hallway, kitchen));
        Floor firstFloor = new Floor(2, "First Floor", list(office));

        // --- SmartHome ---
        SmartHome myHome = new SmartHome("My Smart Home", LocalDate.of(2023, 6, 1), owner, neighbourhood, networkProvider, securityCompany, solarPanel, sewerageSystem, garage, garden, homeGym, list(groundFloor, firstFloor));

        // --- Street & District ---
        Street mainStreet = new Street("123 Main Street", "62701", list(myHome));
        District district = new District("Westside", "Springfield", "USA", list(mainStreet));

        // --- Output ---
        System.out.println(district.listAllDevices());
        System.out.println(mainStreet.streetInfo());
        System.out.println(myHome.listAllDevices());

        System.out.println("Total smart homes: " + SmartHome.getTotalHomes());
        System.out.println("Total devices created: " + Device.getDeviceCount());

        // --- Polymorphism demonstration ---
        Device device1 = new SmartLight("Bed Light", new BigDecimal("17.99"), LocalDate.of(2024, 3, 10), "cool blue", "Philips Hue", 20, false);

        Device device2 = new SmartTV("Bedroom TV", new BigDecimal("799.99"), LocalDate.of(2023, 11, 20), "Samsung", 55, true);

        Device device3 = new Thermostat("Bathroom Thermostat", new BigDecimal("89.99"), LocalDate.of(2023, 12, 1), 22.0, 24.0, 100.0);

        device1.operate();
        device2.operate();
        device3.operate();

        Connectable tv = new SmartTV("tv", new BigDecimal(455.0), LocalDate.of(2023, 11, 20), "Samsung", 55, true);
        Connectable router = new SmartRouter("router", new BigDecimal(56.9), LocalDate.of(2026, 10, 3), "fhriuhf", 5, 67.8, true);

        connectDevice(tv);
        connectDevice(router);

        try {
            Device device4 = new SmartLight();
            device4.setInstalledDate(null);
        } catch (DeviceInstallationException e) {
            System.out.println("there is no device installed");
        } finally {
            System.out.println("Instalation attempt finished");
        }

        try (SmartHomeLogger logger = new SmartHomeLogger()) {

            logger.log("Smart home system started");

        } catch (Exception e) {

            System.out.println("Logging error: " + e.getMessage());

        }

        SmartRouter router1 = new SmartRouter();
        router1.isConnectedToWifi();

        livingRoomThermostat.setTemperatureSetting(-50);

    }


    public static void connectDevice(Connectable device) {

        device.connect();
    }
}

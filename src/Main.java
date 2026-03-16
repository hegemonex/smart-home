import district.*;
import district.house.devices.*;
import district.house.devices.climateDevice.SmartAirConditioner;
import district.house.devices.climateDevice.Thermostat;
import district.house.devices.sensors.MotionSensor;
import district.house.devices.sensors.SecurityCamera;
import district.house.devices.smartDevices.*;
import district.house.rooms.*;
import district.house.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // --- Devices ---
        SmartLight ceilingLight = new SmartLight(
                "Ceiling Light", new BigDecimal("49.99"), LocalDate.of(2024, 3, 10),
                "Warm White", "Philips Hue", 80, true
        );

        SmartLight floorLamp = new SmartLight(
                "Floor Lamp", new BigDecimal("29.99"), LocalDate.of(2024, 3, 10),
                "Soft White", "Ikea Tradfri", 60, true
        );

        SmartTV livingRoomTV = new SmartTV(
                "Living Room TV", new BigDecimal("799.99"), LocalDate.of(2023, 11, 20),
                "Samsung", 55, true
        );

        SmartSpeaker livingRoomSpeaker = new SmartSpeaker(
                "Living Room Speaker", new BigDecimal("129.99"), LocalDate.of(2024, 1, 5),
                "Alexa", 5, 20, true
        );

        Thermostat livingRoomThermostat = new Thermostat(
                "Living Room Thermostat", new BigDecimal("89.99"), LocalDate.of(2023, 12, 1),
                22.0, 24.0, 100.0
        );

        SmartAirConditioner livingRoomAC = new SmartAirConditioner(
                "Living Room AC", new BigDecimal("349.99"), LocalDate.of(2023, 6, 15),
                "Cool", 21.0, 3, 26.7
        );

        MotionSensor hallwaySensor = new MotionSensor(
                "Hallway Motion Sensor", new BigDecimal("39.99"), LocalDate.of(2024, 2, 14),
                7, 10, 67.8
        );

        SmartDoorLock mainDoorLock = new SmartDoorLock(
                "Main Door Lock", new BigDecimal("199.99"), LocalDate.of(2024, 1, 20),
                "Yale Assure"
        );

        SecurityCamera frontDoorCamera = new SecurityCamera(
                "Front Door Camera", new BigDecimal("149.99"), LocalDate.of(2024, 2, 1),
                "4K", "Infrared", 56.4
        );

        SmartPlug coffeeMachinePlug = new SmartPlug(
                "Coffee Machine Plug", new BigDecimal("24.99"), LocalDate.of(2024, 3, 5),
                "Coffee Machine", new BigDecimal("1200.00"), false
        );

        SmartRouter officeRouter = new SmartRouter(
                "Office Router", new BigDecimal("189.99"), LocalDate.of(2023, 10, 10),
                "MySmartHome_5G", 12, 2.4, false
        );

        // --- Standalone Classes ---
        Owner owner = new Owner(
                "John Smith", "john@example.com", "+1-555-9999",
                LocalDate.of(2022, 5, 1)
        );

        Neighbourhood neighbourhood = new Neighbourhood("Maple Grove", "Springfield", 120, true);

        NetworkProvider networkProvider = new NetworkProvider(
                "SpeedNet ISP", new BigDecimal("59.99"), 500, "Fiber"
        );

        SecurityCompany securityCompany = new SecurityCompany(
                "ShieldGuard", "+1-555-0911", new BigDecimal("39.99"), true
        );

        SolarPanel solarPanel = new SolarPanel(
                "SunPower", new BigDecimal("8.50"), 12, LocalDate.of(2022, 7, 15)
        );

        SewerageSystem sewerageSystem = new SewerageSystem(
                "City Sewerage Co.", true, LocalDate.of(2024, 9, 10), "PVC"
        );

        // --- Rooms extending Room ---
        Garage garage = new Garage(
                "Garage",
                new BigDecimal("50.0"),
                new DeviceGroup[]{},
                2
        );

        Garden garden = new Garden(
                "Garden",
                new BigDecimal("120.00"),
                new DeviceGroup[]{},
                true
        );

        HomeGym homeGym = new HomeGym(
                "Home Gym",
                new BigDecimal("30.00"),
                new DeviceGroup[]{},
                10
        );

        // --- Device Zones ---
        DeviceZone northLighting = new DeviceZone("North Lighting", "North Wall",
                new Device[]{ceilingLight});

        DeviceZone southLighting = new DeviceZone("South Lighting", "South Corner",
                new Device[]{floorLamp});

        DeviceZone mainEntertainment = new DeviceZone("Main Entertainment", "East Wall",
                new Device[]{livingRoomTV, livingRoomSpeaker});

        DeviceZone climateControl = new DeviceZone("Climate Control", "Central",
                new Device[]{livingRoomThermostat, livingRoomAC});

        DeviceZone entrySecurity = new DeviceZone("Entry Security", "Front Door",
                new Device[]{mainDoorLock, frontDoorCamera});

        DeviceZone motionDetection = new DeviceZone("Motion Detection", "Ceiling",
                new Device[]{hallwaySensor});

        DeviceZone kitchenAppliances = new DeviceZone("Appliances", "Counter",
                new Device[]{coffeeMachinePlug});

        DeviceZone networkZone = new DeviceZone("Network", "Desk",
                new Device[]{officeRouter});

        // --- Device Groups ---
        DeviceGroup livingLighting = new DeviceGroup("Living Lighting", "Lighting",
                new DeviceZone[]{northLighting, southLighting});

        DeviceGroup livingEntertainment = new DeviceGroup("Entertainment", "Entertainment",
                new DeviceZone[]{mainEntertainment});

        DeviceGroup livingClimate = new DeviceGroup("Climate", "Climate",
                new DeviceZone[]{climateControl});

        DeviceGroup hallwaySecurity = new DeviceGroup("Security", "Security",
                new DeviceZone[]{entrySecurity, motionDetection});

        DeviceGroup kitchenGroup = new DeviceGroup("Kitchen Devices", "Appliances",
                new DeviceZone[]{kitchenAppliances});

        DeviceGroup officeNetwork = new DeviceGroup("Network", "Network",
                new DeviceZone[]{networkZone});

        // --- Rooms ---
        Room livingRoom = new Room("Living Room", new BigDecimal("35.00"),
                new DeviceGroup[]{livingLighting, livingEntertainment, livingClimate});

        Room hallway = new Room("Hallway", new BigDecimal("12.00"),
                new DeviceGroup[]{hallwaySecurity});

        Room kitchen = new Room("Kitchen", new BigDecimal("20.00"),
                new DeviceGroup[]{kitchenGroup});

        Room office = new Room("Office", new BigDecimal("18.00"),
                new DeviceGroup[]{officeNetwork});

        // --- Floors ---
        Floor groundFloor = new Floor(1, "Ground Floor", new Room[]{livingRoom, hallway, kitchen});
        Floor firstFloor = new Floor(2, "First Floor", new Room[]{office});

        // --- SmartHome ---
        SmartHome myHome = new SmartHome(
                "My Smart Home", LocalDate.of(2023, 6, 1),
                owner, neighbourhood, networkProvider, securityCompany,
                solarPanel, sewerageSystem, garage, garden, homeGym,
                new Floor[]{groundFloor, firstFloor}
        );

        // --- Street & District ---
        Street mainStreet = new Street("123 Main Street", "62701", new SmartHome[]{myHome});
        District district = new District("Westside", "Springfield", "USA", new Street[]{mainStreet});

        // --- Output ---
        System.out.println(district.districtInfo());
        System.out.println(mainStreet.streetInfo());
        System.out.println(myHome.listAllDevices());

        System.out.println("Total smart homes: " + SmartHome.getTotalHomes());
        System.out.println("Total devices created: " + Device.getDeviceCount());

        // --- Polymorphism demonstration ---
        Device device1 = new SmartLight("Bed Light", new BigDecimal("17.99"), LocalDate.of(2024, 3, 10),
                "cool blue", "Philips Hue", 20, false);

        Device device2 = new SmartTV("Bedroom TV", new BigDecimal("799.99"),
                LocalDate.of(2023, 11, 20), "Samsung", 55, true);

        Device device3 = new Thermostat("Bathroom Thermostat", new BigDecimal("89.99"),
                LocalDate.of(2023, 12, 1), 22.0, 24.0, 100.0);

        device1.operate();
        device2.operate();
        device3.operate();
    }
}
import model.Room;
import model.SmartHome;
import model.devices.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Living Room devices
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

        // Hallway devices
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

        // Kitchen devices
        SmartLight kitchenLight = new SmartLight(
                "Kitchen Light", new BigDecimal("34.99"), LocalDate.of(2024, 3, 10),
                "Cool White", "Ikea Tradfri", 100
        );
        SmartPlug coffeeMachinePlug = new SmartPlug(
                "Coffee Machine Plug", new BigDecimal("24.99"), LocalDate.of(2024, 3, 5),
                "Coffee Machine", new BigDecimal("1200.00")
        );

        // Office devices
        SmartRouter officeRouter = new SmartRouter(
                "Office Router", new BigDecimal("189.99"), LocalDate.of(2023, 10, 10),
                "MySmartHome_5G", 12, 2.4
        );

        // Assemble rooms
        Device[] livingRoomDevices = {livingRoomLight, livingRoomTV, livingRoomSpeaker, livingRoomThermostat, livingRoomAC};
        Device[] hallwayDevices = {hallwaySensor, mainDoorLock, frontDoorCamera};
        Device[] kitchenDevices = {kitchenLight, coffeeMachinePlug};
        Device[] officeDevices = {officeRouter};

        Room livingRoom = new Room("Living Room", 1, livingRoomDevices);
        Room hallway = new Room("Hallway", 1, hallwayDevices);
        Room kitchen = new Room("Kitchen", 1, kitchenDevices);
        Room office = new Room("Office", 2, officeDevices);

        Room[] homeRooms = {livingRoom, hallway, kitchen, office};

        // Root object - fully populated
        SmartHome myHome = new SmartHome(
                "My Smart Home",
                "123 Main Street",
                LocalDate.of(2023, 6, 1),
                homeRooms
        );

        // Print full hierarchy
        System.out.println(myHome.listAllDevices());

        // SmartLight
        System.out.println(livingRoomLight.turnOn());
        System.out.println(kitchenLight.turnOff());

        // SmartTV
        System.out.println(livingRoomTV.turnOn());
        System.out.println(livingRoomTV.turnOff());

        // SmartSpeaker
        System.out.println(livingRoomSpeaker.turnUpVol());
        System.out.println(livingRoomSpeaker.turnDownVol());

        // Thermostat
        System.out.println(livingRoomThermostat.adjustTemp());

        // SmartAirConditioner
        System.out.println(livingRoomAC.turnOn());
        System.out.println(livingRoomAC.changeMode("Heat"));

        // MotionSensor
        hallwaySensor.setMotionDetected(true);
        System.out.println(hallwaySensor.detectMotion());

        // SmartDoorLock
        System.out.println(mainDoorLock.lock());
        System.out.println(mainDoorLock.unlock());

        // SecurityCamera
        frontDoorCamera.setRecording(true);
        System.out.println(frontDoorCamera.recordingStatus());
        System.out.println(frontDoorCamera.logMotion());

        // SmartPlug
        System.out.println(coffeeMachinePlug.turnOn());
        System.out.println(coffeeMachinePlug.showPowerUsage());

        // SmartRouter
        System.out.println(officeRouter.showNetworkStatus());
        System.out.println(officeRouter.reboot());

        // Stats
        System.out.println("Total smart homes created: " + SmartHome.getTotalHomes());
        System.out.println("Total devices created: " + Device.getDeviceCount());
    }
}
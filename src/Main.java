import model.Room;
import model.SmartHome;
import model.devices.*;

public class Main {
    static void main(String[] args) {
        SmartLights livingRoomLight = new SmartLights("Warm White", "Philips Hue");
        livingRoomLight.setId(1);
        livingRoomLight.setName("Living Room Light");
        livingRoomLight.setBrightness("80%");

        SmartTV livingRoomTV = new SmartTV("Samsung", 55);
        livingRoomTV.setId(9);
        livingRoomTV.setName("Living Room TV");

        Thermostat thermostat = new Thermostat(22.0);
        thermostat.setId(2);
        thermostat.setName("Living Room Thermostat");
        thermostat.setTargetTemp(24.0);

        SecurityCamera frontDoorCam = new SecurityCamera("4K", "Motion Sensor");
        frontDoorCam.setId(3);
        frontDoorCam.setName("Front Door Camera");
        frontDoorCam.setRecording(true);

        MotionSensor hallwaySensor = new MotionSensor(5);
        hallwaySensor.setId(4);
        hallwaySensor.setName("Hallway Motion Sensor");
        hallwaySensor.setMotionDetected(true);

        SmartDoorLock mainDoorLock = new SmartDoorLock("Yale");
        mainDoorLock.setId(5);
        mainDoorLock.setName("Main Door Lock");
        mainDoorLock.setLockState("Locked");

        SmartPlug coffeePlug = new SmartPlug(1200.0);
        coffeePlug.setId(6);
        coffeePlug.setName("Coffee Machine Plug");
        coffeePlug.setConnectedDevice("Coffee Machine");

        SmartSpeaker livingRoomSpeaker = new SmartSpeaker("Alexa");
        livingRoomSpeaker.setId(7);
        livingRoomSpeaker.setName("Living Room Speaker");
        livingRoomSpeaker.setVolume(5.0);

        SmartLights kitchenLight = new SmartLights("Cool White", "Ikea Tradfri");
        kitchenLight.setId(8);
        kitchenLight.setName("Kitchen Light");
        kitchenLight.setBrightness("100%");


        Device[] livingRoomDevices = {livingRoomLight, thermostat, frontDoorCam, livingRoomSpeaker, livingRoomTV};
        Device[] hallwayDevices = {hallwaySensor, mainDoorLock};
        Device[] kitchenDevices = {kitchenLight, coffeePlug};


        Room livingRoom = new Room(1, livingRoomDevices, "Living Room");
        Room hallway = new Room(1, hallwayDevices, "Hallway");
        Room kitchen = new Room(1, kitchenDevices, "Kitchen");


        Room[] homeRooms = {livingRoom, hallway, kitchen};
        SmartHome myHome = new SmartHome("123 Main Street", homeRooms , "My Smart Home");


        System.out.println(myHome.listEverything());

        System.out.println(livingRoomLight.turnOn());
        System.out.println(kitchenLight.turnOff());

        System.out.println(frontDoorCam.recording());
        System.out.println(hallwaySensor.detectMotion());

        System.out.println(mainDoorLock.lock());
        System.out.println(mainDoorLock.unlock());

        System.out.println(coffeePlug.turnOn());
        System.out.println(coffeePlug.showPowerUsage());

        System.out.println(livingRoomSpeaker.turnUpVol());
        System.out.println(livingRoomSpeaker.turnDownVol());

        System.out.println(thermostat.setTheTemp());

        System.out.println(livingRoomTV.turnOn());
        System.out.println(livingRoomTV.turnOff());

        System.out.println("Total smart homes created: " + SmartHome.getTotalHomes());
    }
}

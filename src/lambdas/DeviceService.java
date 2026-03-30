package lambdas;

import district.house.devices.Device;
import enums.AlertLevel;
import lambdas.CustomFunctionalInterfaces.AlertHandler;
import lambdas.CustomFunctionalInterfaces.DeviceAction;
import lambdas.CustomFunctionalInterfaces.DeviceFilter;

import java.math.BigDecimal;
import java.util.function.*;

public class DeviceService {

    public void scheduleHealthCheck(Runnable healthCheck) {
        System.out.println("[DeviceService] Scheduling health check...");
        healthCheck.run();
        System.out.println("[DeviceService] Health check complete.");
    }

    public String generateSystemMessage(Supplier<String> messageSupplier) {
        System.out.println("[DeviceService] Requesting system message...");
        String message = messageSupplier.get();
        System.out.println("[DeviceService] Message: " + message);
        return message;
    }

    public void processAllDevices(Device[] devices, Consumer<Device> processor) {
        if (devices == null) return;
        System.out.println("[DeviceService] Processing " + devices.length + " device(s)...");
        for (Device device : devices) {
            processor.accept(device);
        }
    }

    public String formatDevice(Device device, Function<Device, String> formatter) {
        return formatter.apply(device);
    }

    public Device[] filterDevices(Device[] devices, Predicate<Device> criterion) {
        if (devices == null) return new Device[0];

        int count = 0;
        for (Device d : devices) {
            if (criterion.test(d)) count++;
        }

        Device[] result = new Device[count];
        int i = 0;
        for (Device d : devices) {
            if (criterion.test(d)) result[i++] = d;
        }

        System.out.println("[DeviceService] Filtered " + devices.length
                + " → " + result.length + " device(s) passed.");
        return result;
    }

    public String analyseDeviceCost(Device device, BigDecimal ratePerKwh,
                                    BiFunction<Device, BigDecimal, String> costAnalyser) {
        return costAnalyser.apply(device, ratePerKwh);
    }

    public void triggerAlert(Device device, AlertLevel level,
                             BiConsumer<Device, AlertLevel> alertAction) {
        System.out.println("[DeviceService] Triggering alert for: " + device.getName());
        alertAction.accept(device, level);
    }

    public Device[] applyFilter(Device[] devices, DeviceFilter filter) {
        if (devices == null) return new Device[0];

        int count = 0;
        for (Device d : devices) {
            if (filter.test(d)) count++;
        }
        Device[] result = new Device[count];
        int i = 0;
        for (Device d : devices) {
            if (filter.test(d)) result[i++] = d;
        }
        return result;
    }

    public void runActionOnAll(Device[] devices, DeviceAction action) {
        if (devices == null) return;
        for (Device d : devices) {
            String result = action.execute(d);
            System.out.println("  Action result: " + result);
        }
    }

    public void dispatchAlert(String deviceName, AlertLevel level, AlertHandler handler) {
        System.out.println("[DeviceService] Dispatching alert → " + level.name());
        handler.handle(deviceName, level);
    }
}
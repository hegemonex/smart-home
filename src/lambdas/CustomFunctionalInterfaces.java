package lambdas;

import district.house.devices.Device;
import enums.AlertLevel;

public class CustomFunctionalInterfaces {

    @FunctionalInterface
    public interface DeviceFilter {
        boolean test(Device device);

        default DeviceFilter and(DeviceFilter other) {
            return device -> this.test(device) && other.test(device);
        }

        default DeviceFilter or(DeviceFilter other) {
            return device -> this.test(device) || other.test(device);
        }
    }

    @FunctionalInterface
    public interface DeviceAction {
        String execute(Device device);

        default DeviceAction andThen(DeviceAction next) {
            return device -> {
                this.execute(device);
                return next.execute(device);
            };
        }
    }

    @FunctionalInterface
    public interface AlertHandler {
        void handle(String deviceName, AlertLevel level);

        default AlertHandler andAlso(AlertHandler other) {
            return (deviceName, level) -> {
                this.handle(deviceName, level);
                other.handle(deviceName, level);
            };
        }
    }
}
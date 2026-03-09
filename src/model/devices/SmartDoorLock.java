package model.devices;

public class SmartDoorLock extends Device {
    private String lockModel;
    private String lockState;

    public SmartDoorLock(String lockModel) {
        this.lockModel = lockModel;
    }

    public String getLockState() { return lockState; }
    public void setLockState(String lockState) { this.lockState = lockState; }

    @Override
    public String deviceInfo() {
        return super.deviceInfo() + " the model of the lock is " + lockModel;
    }

    public String lock() {
        lockState = "Locked";
        return "Locked! the state of the lock is " + lockState;
    }

    public String unlock() {
        lockState = "Unlocked";
        return "Unlocked! the state of the lock is " + lockState;
    }
}

package model.devices;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MotionSensor extends Device {

    private int sensitivity;
    private boolean motionDetected;
    private int detectionRangeMeters;

    public MotionSensor(String name, BigDecimal price, LocalDate installedDate,
                        int sensitivity, int detectionRangeMeters) {
        super(name, price, installedDate);
        this.sensitivity = sensitivity;
        this.detectionRangeMeters = detectionRangeMeters;
        this.motionDetected = false;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public void setMotionDetected(boolean motionDetected) {
        this.motionDetected = motionDetected;
    }

    public int getDetectionRangeMeters() {
        return detectionRangeMeters;
    }

    public void setDetectionRangeMeters(int detectionRangeMeters) {
        this.detectionRangeMeters = detectionRangeMeters;
    }

    @Override
    public String deviceInfo() {
        return super.deviceInfo() + " | Sensitivity: " + sensitivity + ", Range: " + detectionRangeMeters + "m";
    }

    public String detectMotion() {
        if (motionDetected) {
            return getName() + ": Motion detected! Alert!";
        } else {
            return getName() + ": No motion detected.";
        }
    }
}
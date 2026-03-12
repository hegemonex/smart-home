package district.house.devices;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SecurityCamera extends Device {

    private String resolution;
    private String sensorType;
    private boolean recording;
    private LocalDateTime lastMotionDetected;

    public SecurityCamera(String name, BigDecimal price, LocalDate installedDate,
                          String resolution, String sensorType) {
        super(name, price, installedDate);
        this.resolution = resolution;
        this.sensorType = sensorType;
        this.recording = false;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public boolean isRecording() {
        return recording;
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }

    public LocalDateTime getLastMotionDetected() {
        return lastMotionDetected;
    }

    public void setLastMotionDetected(LocalDateTime lastMotionDetected) {
        this.lastMotionDetected = lastMotionDetected;
    }

    @Override
    public String deviceInfo() {
        return super.deviceInfo() + " | Resolution: " + resolution + ", Sensor: " + sensorType;
    }

    public String recordingStatus() {
        if (recording) {
            return getName() + " is currently recording.";
        } else {
            return getName() + " is not recording.";
        }
    }

    public String logMotion() {
        lastMotionDetected = LocalDateTime.now();
        return getName() + " detected motion at " + lastMotionDetected;
    }
}
package fhtw.maintenancemonitor;

public class MaintenanceMessage {
    private String message;
    private boolean alarm;

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public MaintenanceMessage(String message, boolean alarm) {
        this.message = message;
        this.alarm = alarm;
    }
}

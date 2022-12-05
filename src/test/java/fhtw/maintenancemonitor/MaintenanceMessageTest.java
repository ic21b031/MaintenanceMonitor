package fhtw.maintenancemonitor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceMessageTest {

    @Test
    @DisplayName("No alarm")
    void isAlarm() {
        MaintenanceMessage maintenanceMessage = new MaintenanceMessage("OK", false);
        assertFalse(maintenanceMessage.isAlarm());
    }

    @Test
    @DisplayName("Set alarm to true")
    void setAlarm() {
        MaintenanceMessage maintenanceMessage = new MaintenanceMessage("OK", false);
        assertFalse(maintenanceMessage.isAlarm());
        maintenanceMessage.setAlarm(true);
        assertTrue(maintenanceMessage.isAlarm());
    }

    @Test
    @DisplayName("Message should be OK")
    void getMessage() {
        MaintenanceMessage maintenanceMessage = new MaintenanceMessage("OK", false);
        assertEquals("OK", maintenanceMessage.getMessage());
    }

    @Test
    @DisplayName("Set message to Very special Message")
    void setMessage() {
        MaintenanceMessage maintenanceMessage = new MaintenanceMessage("OK", false);
        maintenanceMessage.setMessage("Very special message");
        assertEquals("Very special message", maintenanceMessage.getMessage());
    }

}
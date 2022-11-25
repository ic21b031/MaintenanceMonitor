package fhtw.maintenancemonitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceMonitorController {
    private final MaintenanceMessage maintenanceMessage = new MaintenanceMessage("Everything works as expected", false);

    @GetMapping("/api/message/reset")
    public String _resetMessage() {
        maintenanceMessage.setMessage("Everything works as expected");
        maintenanceMessage.setAlarm(false);
        return "ok";
    }

}

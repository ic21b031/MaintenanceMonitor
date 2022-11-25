package fhtw.maintenancemonitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceMonitorController {
    private final MaintenanceMessage maintenanceMessage = new MaintenanceMessage("Everything works as expected", false);

    @GetMapping("/api/message/set")
    public String _setMessage(@RequestParam(value = "m") String m) {
        maintenanceMessage.setMessage(m);
        maintenanceMessage.setAlarm(!m.equals("Everything works as expected"));
        return "ok";
    }
    @GetMapping("/api/message/reset")
    public String _resetMessage() {
        maintenanceMessage.setMessage("Everything works as expected");
        maintenanceMessage.setAlarm(false);
        return "ok";
    }

}

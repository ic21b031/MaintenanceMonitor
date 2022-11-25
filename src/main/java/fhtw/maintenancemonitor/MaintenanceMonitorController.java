package fhtw.maintenancemonitor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/api/message", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> _showMessage() {
        String retMessage = String.format("""
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <title>Maintenance Monitor</title>
                    <style>
                        .center {
                            position: fixed;
                            top: 50%%;
                            left: 50%%;
                            transform: translate(-50%%, -50%%);
                            width: 500px;
                            height: 300px;
                            text-align: center;
                            padding: 20px;
                            font-family: monospace, monospace;
                        }

                        body {
                            background-image: linear-gradient(to right, white, %s, white);
                        }
                    </style>
                </head>
                                
                <body>
                <div class=" center">
                    <h1>Maintenance Monitor</h1>
                    <h3>%s</h3>
                </div>
                </body>

                </html>""", maintenanceMessage.isAlarm() ? "red" : "green", maintenanceMessage.getMessage());

        return new ResponseEntity<String>(retMessage, HttpStatus.OK);
    }

    @GetMapping("/api/message/reset")
    public String _resetMessage() {
        maintenanceMessage.setMessage("Everything works as expected");
        maintenanceMessage.setAlarm(false);
        return "ok";
    }

}

package TeamZenbyte.Nagar_Alert_Hub.controller;

import TeamZenbyte.Nagar_Alert_Hub.dto.AlertDTO;
import TeamZenbyte.Nagar_Alert_Hub.dto.AlertResponseDTO;
import TeamZenbyte.Nagar_Alert_Hub.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nagar-alert-hub-alert")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AlertController {
    private final AlertService alertService;

    @GetMapping("/alert-list")
    public ResponseEntity<List<AlertResponseDTO>>alertsList(){
        return ResponseEntity.ok(alertService.getAllAlerts());
    }
    @PostMapping("/add-alert")
    public ResponseEntity<AlertResponseDTO>createAlert(@RequestBody AlertDTO alertDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(alertService.addAlert(alertDTO));
    }
}

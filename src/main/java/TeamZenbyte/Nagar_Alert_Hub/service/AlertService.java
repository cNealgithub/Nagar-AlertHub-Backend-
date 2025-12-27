package TeamZenbyte.Nagar_Alert_Hub.service;

import TeamZenbyte.Nagar_Alert_Hub.dto.AlertDTO;
import TeamZenbyte.Nagar_Alert_Hub.dto.AlertResponseDTO;

import java.util.List;

public interface AlertService {
    AlertResponseDTO addAlert(AlertDTO alertDTO);
    List<AlertResponseDTO> getAllAlerts();
}

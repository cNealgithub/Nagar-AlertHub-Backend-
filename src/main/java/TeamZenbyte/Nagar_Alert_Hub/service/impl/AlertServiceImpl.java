package TeamZenbyte.Nagar_Alert_Hub.service.impl;

import TeamZenbyte.Nagar_Alert_Hub.dto.AlertDTO;
import TeamZenbyte.Nagar_Alert_Hub.dto.AlertResponseDTO;
import TeamZenbyte.Nagar_Alert_Hub.entity.Alert;
import TeamZenbyte.Nagar_Alert_Hub.service.AlertService;
import TeamZenbyte.Nagar_Alert_Hub.util.Priorty_determiner;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.google.cloud.firestore.QueryDocumentSnapshot;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {
    private final ModelMapper modelMapper;
    private final Firestore firestore;
    private final Priorty_determiner priortyDeterminer;

    @Override
    public AlertResponseDTO addAlert(AlertDTO alertDTO) {
        try{
            Alert newAlert = modelMapper.map(alertDTO, Alert.class);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime time = LocalTime.now();
            String alertTime = time.format(formatter);
            newAlert.setTime(alertTime);
            newAlert.setPriority(priortyDeterminer.mapPriority(newAlert.getConfidence()));
            ApiFuture<DocumentReference> alerts = firestore.collection("alerts").add(newAlert);
            // Get the generated document reference
            DocumentReference docRef = alerts.get();

            // Set the Firestore ID back into the entity
            newAlert.setId(docRef.getId());

            return modelMapper.map(newAlert, AlertResponseDTO.class);
        } catch (Exception e) {
            log.error("The alert couldn't be added due to the error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AlertResponseDTO> getAllAlerts() {
        try {
            // Fetch all documents from "alerts" collection
            List<QueryDocumentSnapshot> documents = firestore.collection("alerts")
                    .get()
                    .get()
                    .getDocuments();

            // Map each document to AlertResponseDTO
            return documents.stream()
                    .map(doc -> {
                        Alert alert = doc.toObject(Alert.class);
                        // set Firestore ID manually
                        alert.setId(doc.getId());
                        return modelMapper.map(alert, AlertResponseDTO.class);
                    })
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Failed to fetch alerts: {}", e.getMessage(), e);
            throw new RuntimeException("Could not retrieve alerts", e);
        }

    }
}

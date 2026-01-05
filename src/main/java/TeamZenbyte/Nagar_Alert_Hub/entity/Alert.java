package TeamZenbyte.Nagar_Alert_Hub.entity;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    @DocumentId
    private String id;
    private String badge;
    private String title;
    private double confidence;   // confidence/delay fieldfor determining priproty of alert
    private String priority;     // Derived from confidence
    private String description;
    private String location;
    private String time;

}

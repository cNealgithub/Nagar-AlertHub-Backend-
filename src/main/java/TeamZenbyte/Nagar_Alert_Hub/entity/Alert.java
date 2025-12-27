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
    //private String confidence;
    //private String object_detected;
    private String description;
    private String location;
    private String time;

}

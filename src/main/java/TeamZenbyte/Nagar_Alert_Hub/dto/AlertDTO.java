package TeamZenbyte.Nagar_Alert_Hub.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlertDTO {
    private String badge;
    private String title;
    private String description;
    private String location;
    private double confidence;
    private String time;
}

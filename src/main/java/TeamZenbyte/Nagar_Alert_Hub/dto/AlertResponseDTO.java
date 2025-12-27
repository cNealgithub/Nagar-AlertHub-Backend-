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
public class AlertResponseDTO {

        private String id;
        private String badge;
        private String title;
        private String description;
        private String location;
        private String time;
}

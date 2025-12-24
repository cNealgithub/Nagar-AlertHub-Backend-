package TeamZenbyte.Nagar_Alert_Hub.entity;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.ServerTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @DocumentId
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String whatsapp;
    @ServerTimestamp
    private Timestamp createdAt;
}

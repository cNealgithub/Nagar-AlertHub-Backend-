package TeamZenbyte.Nagar_Alert_Hub.config;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FireStoreConfig {
    @Bean
    public Firestore firestore(){//creating a bean for firestoreApp
        if(FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp();
        }
        return FirestoreClient.getFirestore();
    }
}

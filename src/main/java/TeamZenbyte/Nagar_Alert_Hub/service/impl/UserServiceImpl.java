package TeamZenbyte.Nagar_Alert_Hub.service.impl;

import TeamZenbyte.Nagar_Alert_Hub.dto.RegisterUserDTO;
import TeamZenbyte.Nagar_Alert_Hub.dto.UserResponseDTO;
import TeamZenbyte.Nagar_Alert_Hub.entity.User;
import TeamZenbyte.Nagar_Alert_Hub.service.UserService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final Firestore firestore;
    private final ModelMapper modelMapper;

    @Override
    public UserResponseDTO createUser(RegisterUserDTO registerUser) {
        try {
            User savedUser = modelMapper.map(registerUser, User.class);
            ApiFuture<DocumentReference> users = firestore.collection("users").add(savedUser);
            return modelMapper.map(savedUser, UserResponseDTO.class);
        } catch (Exception e) {
            log.error("Error occured while registering user: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

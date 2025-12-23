package TeamZenbyte.Nagar_Alert_Hub.service;

import TeamZenbyte.Nagar_Alert_Hub.dto.RegisterUserDTO;
import TeamZenbyte.Nagar_Alert_Hub.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(RegisterUserDTO registerUser);
}

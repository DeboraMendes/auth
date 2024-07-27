package com.deboramendes.auth.services.user;

import com.deboramendes.auth.controllers.dto.request.UserRequestDTO;
import com.deboramendes.auth.repositories.entities.user.UserEntity;

public interface UserCreationService {
    UserEntity createUser(final UserRequestDTO userRequestDTO);
}

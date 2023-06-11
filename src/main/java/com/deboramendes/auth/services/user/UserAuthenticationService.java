package com.deboramendes.auth.services.user;

import com.deboramendes.auth.controllers.dto.request.UserRequestDTO;
import com.deboramendes.auth.exceptions.UserAuthenticationException;

public interface UserAuthenticationService {
    String loginUser(final UserRequestDTO userRequestDTO) throws UserAuthenticationException;
}

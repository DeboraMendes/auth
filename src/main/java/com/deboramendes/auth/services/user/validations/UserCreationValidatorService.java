package com.deboramendes.auth.services.user.validations;

import com.deboramendes.auth.controllers.dto.request.UserRequestDTO;
import com.deboramendes.auth.exceptions.BusinessException;

public interface UserCreationValidatorService {
    void validate(final UserRequestDTO userRequestDTO) throws BusinessException;
}

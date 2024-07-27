package com.deboramendes.auth.services.user.validations.impl;

import com.deboramendes.auth.controllers.dto.request.UserRequestDTO;
import com.deboramendes.auth.exceptions.AppExceptionGenerator;
import com.deboramendes.auth.exceptions.BusinessException;
import com.deboramendes.auth.repositories.UserRepository;
import com.deboramendes.auth.services.user.validations.UserCreationValidatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExistingUserCreationValidatorServiceImpl implements UserCreationValidatorService {

    private final UserRepository userRepository;

    @Override
    public void validate(final UserRequestDTO userRequestDTO) throws BusinessException {
        log.trace("m=validate(username={})", userRequestDTO.getUsername());

        final boolean exists = userRepository.findByUsername(userRequestDTO.getUsername()).isPresent();

        if (exists) {
            throw AppExceptionGenerator.generateBusinessException("User already exists");
        }

    }
}

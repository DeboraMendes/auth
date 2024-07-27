package com.deboramendes.auth.services.user.impl;

import com.deboramendes.auth.controllers.dto.request.UserRequestDTO;
import com.deboramendes.auth.repositories.UserRepository;
import com.deboramendes.auth.repositories.entities.user.UserEntity;
import com.deboramendes.auth.services.factories.UserFactoty;
import com.deboramendes.auth.services.user.UserCreationService;
import com.deboramendes.auth.services.user.validations.UserCreationValidatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCreationServiceImpl implements UserCreationService {

    private final List<UserCreationValidatorService> userCreationValidatorServices;
    private final UserFactoty userFactoty;
    private final UserRepository userRepository;

    @Override
    public UserEntity createUser(final UserRequestDTO userRequestDTO) {
        log.trace("m=createUser(username={})", userRequestDTO.getUsername());

        userCreationValidatorServices.forEach(impl -> impl.validate(userRequestDTO));

        final UserEntity newUserEntity = userFactoty.createNewUser(userRequestDTO.getUsername(), userRequestDTO.getPassword());

        final UserEntity userEntity = userRepository.save(newUserEntity);

        log.trace("m=createUser(id={})", userEntity.getId());

        return userEntity;
    }
}

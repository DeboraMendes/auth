package com.deboramendes.auth.controllers.v1.impl;

import com.deboramendes.auth.controllers.dto.response.UserAuthenticationResponseDTO;
import com.deboramendes.auth.controllers.dto.request.UserRequestDTO;
import com.deboramendes.auth.controllers.dto.response.UserCreationResponseDTO;
import com.deboramendes.auth.controllers.mappers.UserAuthenticationMapper;
import com.deboramendes.auth.controllers.mappers.UserCreationMapper;
import com.deboramendes.auth.controllers.v1.UserController;
import com.deboramendes.auth.exceptions.BusinessException;
import com.deboramendes.auth.exceptions.UserAuthenticationException;
import com.deboramendes.auth.repositories.entities.user.UserEntity;
import com.deboramendes.auth.services.user.UserAuthenticationService;
import com.deboramendes.auth.services.user.UserCreationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserCreationService userCreationService;
    private final UserCreationMapper userCreationMapper;

    private final UserAuthenticationService userAuthenticationService;
    private final UserAuthenticationMapper userAuthenticationMapper;

    @Override
    @PostMapping
    public ResponseEntity<UserCreationResponseDTO> createUser(@Valid @RequestBody final UserRequestDTO userRequestDTO) throws BusinessException {
        log.trace("m=createUser(userRequestDTO(username={}))", userRequestDTO.getUsername());
        final UserEntity userEntity = userCreationService.createUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreationMapper.toDTO(userEntity));
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<UserAuthenticationResponseDTO> loginUser(@Valid @RequestBody final UserRequestDTO userRequestDTO) throws UserAuthenticationException {
        log.trace("m=loginUser(userRequestDTO(username={}))", userRequestDTO.getUsername());
        final String token = userAuthenticationService.loginUser(userRequestDTO);
        return ResponseEntity.ok().body(userAuthenticationMapper.toDTO(token));
    }
}

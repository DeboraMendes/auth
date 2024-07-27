package com.deboramendes.auth.services.user.impl;

import com.deboramendes.auth.controllers.dto.request.UserRequestDTO;
import com.deboramendes.auth.exceptions.AppExceptionGenerator;
import com.deboramendes.auth.exceptions.UserAuthenticationException;
import com.deboramendes.auth.services.jwt.JWTGeneratorService;
import com.deboramendes.auth.services.password.PasswordEncoderService;
import com.deboramendes.auth.services.user.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoderService passwordEncoderService;
    private final JWTGeneratorService jwtGeneratorService;

    @Override
    public String loginUser(final UserRequestDTO userRequestDTO) throws UserAuthenticationException {
        log.trace("m=loginUser(username={})", userRequestDTO.getUsername());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userRequestDTO.getUsername());

        final boolean isPasswordValid = passwordEncoderService.matches(userRequestDTO.getPassword(), userDetails.getPassword());

        if (!isPasswordValid) {
            throw AppExceptionGenerator.generateUserAuthenticationException("Invalid user password");
        }

        final String token = jwtGeneratorService.generateToken(userDetails);

        log.trace("m=loginUser(token)");

        return token;
    }
}

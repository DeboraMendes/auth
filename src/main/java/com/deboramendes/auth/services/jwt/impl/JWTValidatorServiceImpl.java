package com.deboramendes.auth.services.jwt.impl;

import com.deboramendes.auth.services.jwt.JWTValidatorService;
import com.deboramendes.auth.services.jwt.validations.JWTCustomValidatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JWTValidatorServiceImpl implements JWTValidatorService {

    private final List<JWTCustomValidatorService> jWTCustomValidatorServices;

    @Override
    public boolean isTokenValid(final String token, final UserDetails userDetails) {
        log.trace("m=isTokenValid(token,userDetails)");
        return jWTCustomValidatorServices.stream().allMatch(impl -> impl.isValid(token, userDetails));
    }
}

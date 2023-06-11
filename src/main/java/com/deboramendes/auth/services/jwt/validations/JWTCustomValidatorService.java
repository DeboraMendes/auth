package com.deboramendes.auth.services.jwt.validations;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTCustomValidatorService {
    boolean isValid(final String token, final UserDetails userDetails);
}

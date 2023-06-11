package com.deboramendes.auth.services.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTValidatorService {
    boolean isTokenValid(final String token, final UserDetails userDetails);
}

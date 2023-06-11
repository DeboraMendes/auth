package com.deboramendes.auth.services.jwt;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTGeneratorService {
    String generateToken(final UserDetails userDetails);
    String generateToken(final Map<String, Object> extractClaims, final UserDetails userDetails);
}

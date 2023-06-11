package com.deboramendes.auth.services.jwt;

import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.function.Function;

public interface JWTExtractorService {
    String extractUsername(final String token);
    Date extractExpiration(final String token);
    <T> T extractClaim(final String token, final Function<Claims, T> claimsResolver);
}

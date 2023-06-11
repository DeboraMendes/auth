package com.deboramendes.auth.services.jwt.validations.impl;

import com.deboramendes.auth.services.jwt.JWTExtractorService;
import com.deboramendes.auth.services.jwt.validations.JWTCustomValidatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class JWTExpirationCustomValidatorService implements JWTCustomValidatorService {

    private final JWTExtractorService jwtExtractorService;

    @Override
    public boolean isValid(final String token, final UserDetails userDetails) {
        log.trace("m=isValid(token, userDetails)");
        final Date expiration = jwtExtractorService.extractExpiration(token);
        return expiration.before(new Date());
    }
}

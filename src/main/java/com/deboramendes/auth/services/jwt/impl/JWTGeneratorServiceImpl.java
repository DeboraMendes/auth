package com.deboramendes.auth.services.jwt.impl;

import com.deboramendes.auth.configurations.properties.JWTProperties;
import com.deboramendes.auth.services.jwt.JWTGeneratorService;
import com.deboramendes.auth.services.jwt.JWTSignerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class JWTGeneratorServiceImpl implements JWTGeneratorService {

    private final JWTProperties jwtProperties;
    private final JWTSignerService jWTSignerService;

    @Override
    public String generateToken(final UserDetails userDetails) {
        log.trace("m=generateToken(userDetails)");
        return generateToken(new HashMap<>(), userDetails);
    }

    @Override
    public String generateToken(final Map<String, Object> extractClaims,
                                final UserDetails userDetails) {
        log.trace("m=generateToken(extractClaims, userDetails)");
        final long currentTimeMillis = System.currentTimeMillis();
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + jwtProperties.getExpiresAt()))
                .signWith(jWTSignerService.getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}

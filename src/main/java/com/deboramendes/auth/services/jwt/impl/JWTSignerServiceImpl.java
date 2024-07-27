package com.deboramendes.auth.services.jwt.impl;

import com.deboramendes.auth.configurations.properties.JWTProperties;
import com.deboramendes.auth.services.jwt.JWTSignerService;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;

@Slf4j
@Service
@RequiredArgsConstructor
public class JWTSignerServiceImpl implements JWTSignerService {

    private final JWTProperties jwtProperties;

    @Override
    public Key getSecretKey() {
        log.trace("m=getSecretKey()");
        final byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

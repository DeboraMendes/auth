package com.deboramendes.auth.services.jwt.impl;

import com.deboramendes.auth.services.jwt.JWTExtractorService;
import com.deboramendes.auth.services.jwt.JWTSignerService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Slf4j
@Service
@RequiredArgsConstructor
public class JWTExtractorServiceImpl implements JWTExtractorService {

    private final JWTSignerService jWTSignerService;

    @Override
    public String extractUsername(final String token) {
        log.trace("m=extractUsername(token)");
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public Date extractExpiration(final String token) {
        log.trace("m=extractExpiration(token)");
        return extractClaim(token, Claims::getExpiration);
    }

    @Override
    public <T> T extractClaim(final String token, final Function<Claims, T> claimsResolver) {
        log.trace("m=extractClaim(token, claimsResolver)");
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(final String token) {
        log.trace("m=extractAllClaims(token)");
        return Jwts
                .parserBuilder()
                .setSigningKey(jWTSignerService.getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

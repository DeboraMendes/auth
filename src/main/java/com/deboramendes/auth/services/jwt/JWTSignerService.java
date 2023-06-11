package com.deboramendes.auth.services.jwt;

import java.security.Key;

public interface JWTSignerService {
    Key getSecretKey();
}

package com.deboramendes.auth.services.password;

public interface PasswordEncoderService {
    String encode(final String rawPassword);

    boolean matches(final String rawPassword, final String encodedPassword);
}

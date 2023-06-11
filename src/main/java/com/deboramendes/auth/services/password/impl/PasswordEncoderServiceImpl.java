package com.deboramendes.auth.services.password.impl;

import com.deboramendes.auth.services.password.PasswordEncoderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordEncoderServiceImpl implements PasswordEncoderService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encode(final String rawPassword) {
        log.trace("m=encode(rawPassword)");
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(final String rawPassword, final String encodedPassword) {
        log.trace("m=matches(rawPassword,encodedPassword)");
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

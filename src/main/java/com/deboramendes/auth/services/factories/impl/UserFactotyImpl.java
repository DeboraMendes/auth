package com.deboramendes.auth.services.factories.impl;

import com.deboramendes.auth.annotations.Factory;
import com.deboramendes.auth.repositories.entities.enums.UserRole;
import com.deboramendes.auth.repositories.entities.user.UserEntity;
import com.deboramendes.auth.services.factories.UserFactoty;
import com.deboramendes.auth.services.password.PasswordEncoderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Factory
@RequiredArgsConstructor
public class UserFactotyImpl implements UserFactoty {

    private final PasswordEncoderService passwordEncoderService;

    @Override
    public UserEntity createNewUser(final String username, final String password) {
        log.trace("m=createNewUser(username, password)");
        return UserEntity.getBuilder()
                .withId(UUID.randomUUID())
                .withUsername(username)
                .withPassword(passwordEncoderService.encode(password))
                .withRole(UserRole.USER)
                .build();
    }
}

package com.deboramendes.auth.services.factories;

import com.deboramendes.auth.repositories.entities.user.UserEntity;

public interface UserFactoty {
    UserEntity createNewUserEntity(final String username, final String password);
}

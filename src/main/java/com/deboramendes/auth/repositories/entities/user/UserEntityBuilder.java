package com.deboramendes.auth.repositories.entities.user;

import com.deboramendes.auth.validations.SelfValidator;
import com.deboramendes.auth.repositories.entities.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntityBuilder extends SelfValidator {
    @NotNull
    private UUID id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private UserRole role;

    public UserEntityBuilder withId(final UUID id) {
        this.id = id;
        return this;
    }

    public UserEntityBuilder withUsername(final String username) {
        this.username = username;
        return this;
    }

    public UserEntityBuilder withPassword(final String password) {
        this.password = password;
        return this;
    }

    public UserEntityBuilder withRole(final UserRole role) {
        this.role = role;
        return this;
    }

    public UserEntity build() {
        validateSelf(this);
        return new UserEntity(this);
    }
}

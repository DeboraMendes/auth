package com.deboramendes.auth.repositories.entities.user;

import com.deboramendes.auth.repositories.entities.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(schema = "auth", name = "users")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    public static UserEntityBuilder getBuilder() {
        return new UserEntityBuilder();
    }

    protected UserEntity(final UserEntityBuilder userEntityBuilder) {
        this.id = userEntityBuilder.getId();
        this.username = userEntityBuilder.getUsername();
        this.password = userEntityBuilder.getPassword();
        this.role = userEntityBuilder.getRole();
    }
}

package com.deboramendes.auth.configurations.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("jwt")
public class JWTProperties {
    private Integer expiresAt;
    private String secretKey;
}

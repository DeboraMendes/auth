package com.deboramendes.auth;

import com.deboramendes.auth.configurations.properties.JWTProperties;
import com.deboramendes.auth.configurations.properties.OpenAPIProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({JWTProperties.class, OpenAPIProperties.class})
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}

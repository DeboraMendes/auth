package com.deboramendes.auth.configurations;

import com.deboramendes.auth.configurations.properties.OpenAPIProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class OpenAPIConfiguration {

    private final OpenAPIProperties openAPIProperties;

    @Bean
    public OpenAPI openAPI() {
        log.debug("m=openAPI()");

        final Server server = new Server();
        server.setUrl(openAPIProperties.getServer().getUrl());
        server.setDescription(openAPIProperties.getServer().getDescription());

        final Contact contact = new Contact();
        contact.setEmail(openAPIProperties.getContact().getEmail());
        contact.setName(openAPIProperties.getContact().getName());
        contact.setUrl(openAPIProperties.getContact().getUrl());

        final Info info = new Info()
                .title(openAPIProperties.getInfo().getTitle())
                .version(openAPIProperties.getInfo().getVersion())
                .description(openAPIProperties.getInfo().getDescription())
                .contact(contact);

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }
}
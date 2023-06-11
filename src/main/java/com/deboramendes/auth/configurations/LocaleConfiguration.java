package com.deboramendes.auth.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.TimeZone;

@Slf4j
@Configuration
public class LocaleConfiguration implements WebMvcConfigurer {

    private static final String AMERICA_SAO_PAULO = "BET";

    @Bean
    public LocaleResolver localeResolver() {
        log.debug("m=localeResolver()");
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        sessionLocaleResolver.setDefaultTimeZone(TimeZone.getTimeZone(AMERICA_SAO_PAULO));
        return sessionLocaleResolver;
    }
}

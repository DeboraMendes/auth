package com.deboramendes.auth.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import java.util.Optional;

@Slf4j
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtil() {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        OBJECT_MAPPER.registerModule(new Jdk8Module());
    }

    public static String convertObjectToJson(final Object object) {
        log.trace("m=convertObjectToJson(object)");
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return Strings.EMPTY;
        }
    }

    public static <T> Optional<T> convertJsonToObject(final String object, final Class<T> tClass) {
        log.trace("m=convertJsonToObject(object, tClass)");
        try {
            return Optional.of(OBJECT_MAPPER.readValue(object, tClass));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}

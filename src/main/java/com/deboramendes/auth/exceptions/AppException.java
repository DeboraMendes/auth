package com.deboramendes.auth.exceptions;

import com.deboramendes.auth.exceptions.enums.AppExceptionType;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class AppException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final LocalDateTime datetime;
    private final AppExceptionType type;
    private final List<String> messages;

    protected AppException(final HttpStatus httpStatus, final AppExceptionType type, final List<String> messages) {
        super(type.getMessage());
        this.httpStatus = httpStatus;
        this.datetime = LocalDateTime.now();
        this.type = type;
        this.messages = messages;
    }

    protected AppException(final HttpStatus httpStatus, final AppExceptionType type, final String message) {
        super(type.getMessage());
        this.httpStatus = httpStatus;
        this.datetime = LocalDateTime.now();
        this.type = type;
        this.messages = List.of(message);
    }

}
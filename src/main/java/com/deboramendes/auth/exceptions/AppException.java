package com.deboramendes.auth.exceptions;

import com.deboramendes.auth.exceptions.enums.AppExceptionMessageEnum;
import com.deboramendes.auth.exceptions.enums.AppExceptionTypeEnum;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class AppException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final LocalDateTime dateTime;
    private final AppExceptionTypeEnum type;
    private final AppExceptionMessageEnum error;
    private final List<String> messages;

    protected AppException(final HttpStatus httpStatus, final AppExceptionTypeEnum type, final AppExceptionMessageEnum message) {
        super(type.getMessage());
        this.httpStatus = httpStatus;
        this.dateTime = LocalDateTime.now();
        this.type = type;
        this.error = message;
        this.messages = List.of(message.getMessage());
    }

    protected AppException(final HttpStatus httpStatus, final AppExceptionTypeEnum type, final List<String> messages) {
        super(type.getMessage());
        this.httpStatus = httpStatus;
        this.dateTime = LocalDateTime.now();
        this.type = type;
        this.error = AppExceptionMessageEnum.INVALID_GENERIC_DATA;
        this.messages = messages;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getCode() {
        return String.format("%s.%s.%s.%s", httpStatus.value(), type.getTypeCode(), error.getDomainCode(), error.getMessageCode());
    }

    public String getReason() {
        return type.getMessage();
    }

    public List<String> getErros() {
        return messages;
    }
}
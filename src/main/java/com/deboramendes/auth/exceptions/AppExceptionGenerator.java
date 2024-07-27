package com.deboramendes.auth.exceptions;

import org.springframework.web.bind.MethodArgumentNotValidException;

public class AppExceptionGenerator {
    public static AppException generateBusinessException(final MethodArgumentNotValidException exception) {
        return new BusinessException(exception);
    }

    public static AppException generateBusinessException(final String message) {
        return new BusinessException(message);
    }

    public static AppException generateResourceNotFoundException(final String message) {
        return new ResourceNotFoundException(message);
    }

    public static AppException generateUserAuthenticationException(final String message) {
        return new UserAuthenticationException(message);
    }
}

package com.deboramendes.auth.exceptions;

import com.deboramendes.auth.exceptions.enums.AppExceptionMessageEnum;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class AppExceptionGenerator {
    public static BusinessException generateBusinessException(final MethodArgumentNotValidException ex) {
        return new BusinessException(ex);
    }

    public static BusinessException generateBusinessException(final AppExceptionMessageEnum message) {
        return new BusinessException(message);
    }

    public static ResourceNotFoundException generateResourceNotFoundException(final AppExceptionMessageEnum message) {
        return new ResourceNotFoundException(message);
    }

    public static UserAuthenticationException generateUserAuthenticationException(final AppExceptionMessageEnum message) {
        return new UserAuthenticationException(message);
    }
}

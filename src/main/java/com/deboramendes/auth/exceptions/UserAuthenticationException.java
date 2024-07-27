package com.deboramendes.auth.exceptions;

import com.deboramendes.auth.exceptions.enums.AppExceptionType;
import org.springframework.http.HttpStatus;

/**
 * To be thrown whenever authentication is invalid.
 */
public class UserAuthenticationException extends AppException {
    protected UserAuthenticationException(final String message) {
        super(HttpStatus.UNAUTHORIZED, AppExceptionType.AUTHENTICATION_ERROR, message);
    }
}

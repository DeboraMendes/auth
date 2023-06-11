package com.deboramendes.auth.exceptions;

import com.deboramendes.auth.exceptions.enums.AppExceptionMessageEnum;
import com.deboramendes.auth.exceptions.enums.AppExceptionTypeEnum;
import org.springframework.http.HttpStatus;

/**
 * To be thrown whenever authentication is invalid.
 */
public class UserAuthenticationException extends AppException {
    protected UserAuthenticationException(final AppExceptionMessageEnum message) {
        super(HttpStatus.UNAUTHORIZED, AppExceptionTypeEnum.AUTHENTICATION_ERROR, message);
    }
}

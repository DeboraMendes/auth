package com.deboramendes.auth.exceptions;

import com.deboramendes.auth.exceptions.enums.AppExceptionType;
import com.deboramendes.auth.exceptions.helpers.AppExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * To be thrown whenever a business rule is violated.
 */
public class BusinessException extends AppException {
    protected BusinessException(final MethodArgumentNotValidException exception) {
        super(HttpStatus.BAD_REQUEST, AppExceptionType.BUSINESS_ERROR, AppExceptionHelper.extractErrors(exception));
    }

    protected BusinessException(final String message) {
        super(HttpStatus.NOT_ACCEPTABLE, AppExceptionType.BUSINESS_ERROR, message);
    }
}

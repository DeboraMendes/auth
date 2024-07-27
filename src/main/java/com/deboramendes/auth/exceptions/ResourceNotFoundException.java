package com.deboramendes.auth.exceptions;

import com.deboramendes.auth.exceptions.enums.AppExceptionType;
import org.springframework.http.HttpStatus;

/**
 * To be thrown whenever any business entity was not found.
 */
public class ResourceNotFoundException extends AppException {
    protected ResourceNotFoundException(final String message) {
        super(HttpStatus.NOT_FOUND, AppExceptionType.DATA_ERROR, message);
    }
}

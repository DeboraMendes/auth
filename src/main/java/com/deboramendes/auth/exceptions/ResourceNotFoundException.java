package com.deboramendes.auth.exceptions;

import com.deboramendes.auth.exceptions.enums.AppExceptionMessageEnum;
import com.deboramendes.auth.exceptions.enums.AppExceptionTypeEnum;
import org.springframework.http.HttpStatus;

/**
 * To be thrown whenever any business entity was not found.
 */
public class ResourceNotFoundException extends AppException {
    protected ResourceNotFoundException(final AppExceptionMessageEnum message) {
        super(HttpStatus.NOT_FOUND, AppExceptionTypeEnum.DATA_ERROR, message);
    }
}

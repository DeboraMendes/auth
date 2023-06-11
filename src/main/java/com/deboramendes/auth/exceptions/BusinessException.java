package com.deboramendes.auth.exceptions;

import com.deboramendes.auth.exceptions.enums.AppExceptionMessageEnum;
import com.deboramendes.auth.exceptions.enums.AppExceptionTypeEnum;
import com.deboramendes.auth.exceptions.helpers.AppExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * To be thrown whenever a business rule is violated.
 */
public class BusinessException extends AppException {
    protected BusinessException(final MethodArgumentNotValidException ex) {
        super(HttpStatus.BAD_REQUEST, AppExceptionTypeEnum.BUSINESS_ERROR, AppExceptionHelper.extractErrors(ex));
    }

    protected BusinessException(final AppExceptionMessageEnum message) {
        super(HttpStatus.NOT_ACCEPTABLE, AppExceptionTypeEnum.BUSINESS_ERROR, message);
    }
}

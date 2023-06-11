package com.deboramendes.auth.controllers.handlers;

import com.deboramendes.auth.controllers.dto.response.AppExceptionResponseDTO;
import com.deboramendes.auth.controllers.mappers.AppExceptionMapper;
import com.deboramendes.auth.exceptions.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final AppExceptionMapper appExceptionMapper;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status,
                                                                  @NonNull WebRequest request) {
        log.trace("m=handleMethodArgumentNotValid(ex, headers, status, request)");
        final AppException appException = AppExceptionGenerator.generateBusinessException(ex);
        return new ResponseEntity<>(appExceptionMapper.toDTO(appException), appException.getHttpStatus());
    }

    @ExceptionHandler(value = {BusinessException.class})
    protected ResponseEntity<AppExceptionResponseDTO> handleBusinessException(AppException appException, WebRequest request) {
        log.trace("m=handleBusinessException(appException, request)");
        return new ResponseEntity<>(appExceptionMapper.toDTO(appException), appException.getHttpStatus());
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    protected ResponseEntity<AppExceptionResponseDTO> handleResourceNotFoundException(AppException appException, WebRequest request) {
        log.trace("m=handleResourceNotFoundException(appException, request)");
        return new ResponseEntity<>(appExceptionMapper.toDTO(appException), appException.getHttpStatus());
    }

    @ExceptionHandler(value = {UserAuthenticationException.class})
    protected ResponseEntity<AppExceptionResponseDTO> handleUserAuthenticationException(AppException appException, WebRequest request) {
        log.trace("m=handleUserAuthenticationException(appException, request)");
        return new ResponseEntity<>(appExceptionMapper.toDTO(appException), appException.getHttpStatus());
    }
}

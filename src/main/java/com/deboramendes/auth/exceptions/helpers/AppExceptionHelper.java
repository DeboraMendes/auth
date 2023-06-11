package com.deboramendes.auth.exceptions.helpers;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

public interface AppExceptionHelper {
    static List<String> extractErrors(final MethodArgumentNotValidException ex) {
        if (ex.getBindingResult().hasFieldErrors()) {
            return ex.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                    .collect(Collectors.toList());
        } else {
            return ex.getBindingResult()
                    .getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
        }
    }
}

package com.deboramendes.auth.exceptions.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppExceptionType {

    BUSINESS_ERROR("Business error"),
    DATA_ERROR("Data error"),
    AUTHENTICATION_ERROR("Authentication error");

    private final String message;
}

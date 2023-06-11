package com.deboramendes.auth.exceptions.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppExceptionTypeEnum {
    BUSINESS_ERROR("1", "Business error"),
    DATA_ERROR("2", "Data error"),
    AUTHENTICATION_ERROR("3", "Authentication error");

    private final String typeCode;
    private final String message;
}

package com.deboramendes.auth.exceptions.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppExceptionMessageEnum {
    //GENERIC
    INVALID_GENERIC_DATA("1", "001", "Invalid data"),

    //USER
    USER_ALREADY_EXISTS("2", "001", "User already exists"),
    USER_NOT_FOUND("2", "002", "User not found"),
    INVALID_USER_PASSWORD("2", "003", "Invalid user password");

    private final String domainCode;
    private final String messageCode;
    private final String message;
}

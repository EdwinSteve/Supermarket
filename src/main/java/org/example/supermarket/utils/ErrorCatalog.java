package org.example.supermarket.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    BAD_REQUEST("ERR400BR", "Bad Request!"),
    RESOURCE_NOT_FOUND("ERR404RNF", "Resource not found!");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

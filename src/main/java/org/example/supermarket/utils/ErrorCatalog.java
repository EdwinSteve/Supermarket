package org.example.supermarket.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    GENERIC_ILLEGAL_ARGUMENT("ERR02GE", "Illegal argument!"),
    CATEGORY_NOT_FOUND("ERR01CA", "Category not found!");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

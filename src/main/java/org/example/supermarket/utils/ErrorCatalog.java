package org.example.supermarket.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    CATEGORY_NOT_FOUND("ERR404CAT", "Category not found!"),
    SUPPLIER_NOT_FOUND("ERR404SUP", "Supplier not found!"),
    PRODUCT_NOT_FOUND("ERR404PRO", "Product not found!");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

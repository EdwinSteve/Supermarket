package org.example.supermarket.application.mapper;


public interface Mapper<FROM, TO> {
    TO mapTo(FROM from);
    FROM mapFrom(TO to);
}
package org.example.supermarket.domain.entity;

import java.io.Serializable;

public interface BaseEntity<ID> extends Serializable {
    ID getId();
}

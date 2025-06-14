package org.example.supermarket.application.port.in;

import org.example.supermarket.domain.pojos.Category;

import java.util.List;

public interface CategoryUsesCases {
    List<Category> findAll();
    Category findById(Integer id);
    Category create(Category category);
    Category update(Integer id, Category category);
    void delete(Integer id);
}

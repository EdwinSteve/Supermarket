package org.example.supermarket.application.service;

import org.example.supermarket.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    Category create(Category category);
    Category update(Integer id, Category category);
    void delete(Integer id);
}

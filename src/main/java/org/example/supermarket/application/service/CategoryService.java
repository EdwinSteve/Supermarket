package org.example.supermarket.application.service;

import org.example.supermarket.application.dto.CategoryDto;
import org.example.supermarket.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(Integer id);
    Category getById(Integer id);
    CategoryDto create(CategoryDto category);
    CategoryDto update(Integer id, CategoryDto category);
    void delete(Integer id);
}

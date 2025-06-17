package org.example.supermarket.application.service;

import lombok.RequiredArgsConstructor;
import org.example.supermarket.domain.entity.Category;
import org.example.supermarket.domain.exception.BadRequestException;
import org.example.supermarket.domain.exception.CategoryNotFoundException;
import org.example.supermarket.domain.repository.CategoryRepository;
import org.example.supermarket.utils.ErrorCatalog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(
                        ErrorCatalog.RESOURCE_NOT_FOUND.getMessage()));
    }

    @Override
    public Category create(Category category) {
        validateCategoryFields(category);
        return repository.save(category);
    }

    @Override
    public Category update(Integer id, Category category) {
        return repository.findById(id)
                .map(savedCategory -> {
                    validateCategoryFields(category);
                    savedCategory.setCategoryName(category.getCategoryName());
                    savedCategory.setCategoryPicture(category.getCategoryPicture());
                    savedCategory.setDescription(category.getDescription());
                    return repository.save(savedCategory);
                })
                .orElseThrow(() -> new CategoryNotFoundException(
                        ErrorCatalog.RESOURCE_NOT_FOUND.getMessage()));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private void validateCategoryFields(Category category) {
        if (category.getCategoryName() == null || category.getCategoryName().isBlank()) {
            throw new BadRequestException(ErrorCatalog.BAD_REQUEST.getMessage());
        }

        if (category.getDescription() == null || category.getDescription().isBlank()) {
            throw new BadRequestException(ErrorCatalog.BAD_REQUEST.getMessage());
        }
    }
}

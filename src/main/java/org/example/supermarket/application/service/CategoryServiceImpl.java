package org.example.supermarket.application.service;

import lombok.RequiredArgsConstructor;
import org.example.supermarket.application.dto.CategoryDto;
import org.example.supermarket.application.mapper.CategoryMapper;
import org.example.supermarket.domain.entity.Category;
import org.example.supermarket.domain.exception.CategoryNotFoundException;
import org.example.supermarket.domain.repository.CategoryRepository;
import org.example.supermarket.utils.ErrorCatalog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public List<CategoryDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public CategoryDto findById(Integer id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(
                        ErrorCatalog.CATEGORY_NOT_FOUND.getMessage())));
    }

    @Override
    public Category getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(
                        ErrorCatalog.CATEGORY_NOT_FOUND.getMessage()));
    }

    @Override
    public CategoryDto create(CategoryDto category) {
        return mapper.toDto(repository.save(mapper.toEntity(category)));
    }

    @Override
    public CategoryDto update(Integer id, CategoryDto category) {
        return mapper.toDto(repository.findById(id)
                .map(savedCategory -> {
                    savedCategory.setCategoryName(category.getCategoryName());
                    savedCategory.setCategoryPicture(category.getCategoryPicture());
                    savedCategory.setDescription(category.getDescription());
                    return repository.save(savedCategory);
                })
                .orElseThrow(() -> new CategoryNotFoundException(
                        ErrorCatalog.CATEGORY_NOT_FOUND.getMessage())));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

package org.example.supermarket.infrastructure.persistence.mapper;

import org.example.supermarket.domain.pojos.Category;
import org.example.supermarket.infrastructure.persistence.model.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {
    ModelMapper modelMapper = new ModelMapper();

    public List<Category> toCategoryList(List<CategoryEntity> categoriesEntity) {
        return modelMapper.map(categoriesEntity, new TypeToken<List<Category>>() {}.getType());
    }

    public Category toCategory(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, Category.class);
    }

    public CategoryEntity toEntity(Category category) {
        return modelMapper.map(category, CategoryEntity.class);
    }
}

package org.example.supermarket.application.mapper;

import org.example.supermarket.application.dto.CategoryDto;
import org.example.supermarket.domain.entity.Category;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {
    ModelMapper modelMapper = new ModelMapper();

    public List<CategoryDto> toDtoList(List<Category> categories) {
        return modelMapper.map(categories, new TypeToken<List<CategoryDto>>() {}.getType());
    }

    public CategoryDto toDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    public Category toEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}

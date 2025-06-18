package org.example.supermarket.unit;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.example.supermarket.application.dto.CategoryDto;
import org.example.supermarket.application.service.CategoryServiceImpl;
import org.example.supermarket.domain.entity.Category;
import org.example.supermarket.domain.exception.CategoryNotFoundException;
import org.example.supermarket.utils.ErrorCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
@Transactional
public class CategoryServiceImplImplTest {
    @Autowired
    private CategoryServiceImpl service;

    @Test
    public void shouldReturnCategoryWhenIdExists() {
        CategoryDto category = CategoryDto.builder()
                .categoryName("Seafood")
                .categoryPicture("")
                .description("Fresh seafood products")
                .build();

        CategoryDto saved = service.create(category);
        CategoryDto found = service.findById(saved.getId());

        Assertions.assertThat(found).isEqualTo(saved);
    }

    @Test
    public void shouldThrowCategoryNotFoundExceptionWhenIdDoesNotExist() {
        CategoryDto category = CategoryDto.builder()
                .categoryName("Seafood")
                .categoryPicture("")
                .description("Fresh seafood products")
                .build();

        Assertions.assertThatThrownBy(() -> {
            service.create(category);
            CategoryDto found = service.findById(1000);})
                .isInstanceOf(CategoryNotFoundException.class)
                .hasMessage(ErrorCatalog.CATEGORY_NOT_FOUND.getMessage());
    }

    @Test
    public void shouldSaveCategorySuccessfully() {
        CategoryDto category = CategoryDto.builder()
                .categoryName("Seafood")
                .categoryPicture("")
                .description("Fresh seafood products")
                .build();

        CategoryDto saved = service.create(category);

        Assertions.assertThat(saved)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(category);
    }
}

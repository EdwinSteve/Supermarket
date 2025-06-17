package org.example.supermarket.unit;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
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
        Category category = Category.builder()
                .categoryName("Seafood")
                .categoryPicture("")
                .description("Fresh seafood products")
                .build();

        Category saved = service.create(category);
        Category found = service.findById(saved.getId());

        Assertions.assertThat(found).isEqualTo(saved);
    }

    @Test
    public void shouldThrowCategoryNotFoundExceptionWhenIdDoesNotExist() {
        Category category = Category.builder()
                .categoryName("Seafood")
                .categoryPicture("")
                .description("Fresh seafood products")
                .build();

        Assertions.assertThatThrownBy(() -> {
            service.create(category);
            Category found = service.findById(1000);})
                .isInstanceOf(CategoryNotFoundException.class)
                .hasMessage(ErrorCatalog.CATEGORY_NOT_FOUND.getMessage());
    }

    @Test
    public void shouldThrowIllegalArgumentSaveCategoryWithBlankName() {
        Category category = Category.builder()
                .categoryName("")
                .categoryPicture("")
                .description("Fresh seafood products")
                .build();

        Assertions.assertThatThrownBy(() -> service.create(category))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCatalog.GENERIC_ILLEGAL_ARGUMENT.getMessage());
    }

    @Test
    public void shouldThrowIllegalArgumentSaveCategoryWithNullName() {
        Category category = Category.builder()
                .categoryPicture("")
                .description("Fresh seafood products")
                .build();

        Assertions.assertThatThrownBy(() -> service.create(category))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCatalog.GENERIC_ILLEGAL_ARGUMENT.getMessage());
    }

    @Test
    public void shouldSaveCategorySuccessfully() {
        Category category = Category.builder()
                .categoryName("Seafood")
                .categoryPicture("")
                .description("Fresh seafood products")
                .build();

        Category saved = service.create(category);

        Assertions.assertThat(saved)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(category);
    }
}

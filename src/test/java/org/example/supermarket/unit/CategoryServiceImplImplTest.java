package org.example.supermarket.unit;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.example.supermarket.application.service.CategoryServiceImpl;
import org.example.supermarket.domain.entity.Category;
import org.example.supermarket.domain.exception.BadRequestException;
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
                .hasMessage(ErrorCatalog.RESOURCE_NOT_FOUND.getMessage());
    }

    @Test
    public void shouldThrowIllegalArgumentSaveCategoryWithBlankName() {
        Category category = Category.builder()
                .categoryName("")
                .categoryPicture("")
                .description("Fresh seafood products")
                .build();

        Assertions.assertThatThrownBy(() -> service.create(category))
                .isInstanceOf(BadRequestException.class)
                .hasMessage(ErrorCatalog.BAD_REQUEST.getMessage());
    }

    @Test
    public void shouldThrowIllegalArgumentSaveCategoryWithNullName() {
        Category category = Category.builder()
                .categoryPicture("")
                .description("Fresh seafood products")
                .build();

        Assertions.assertThatThrownBy(() -> service.create(category))
                .isInstanceOf(BadRequestException.class)
                .hasMessage(ErrorCatalog.BAD_REQUEST.getMessage());
    }

    @Test
    public void shouldThrowIllegalArgumentSaveCategoryWithBlankDescription() {
        Category category = Category.builder()
                .categoryName("Seafood")
                .categoryPicture("")
                .description("")
                .build();

        Assertions.assertThatThrownBy(() -> service.create(category))
                .isInstanceOf(BadRequestException.class)
                .hasMessage(ErrorCatalog.BAD_REQUEST.getMessage());
    }

    @Test
    public void shouldThrowIllegalArgumentSaveCategoryWithNullDescription() {
        Category category = Category.builder()
                .categoryName("Seafood")
                .categoryPicture("")
                .build();

        Assertions.assertThatThrownBy(() -> service.create(category))
                .isInstanceOf(BadRequestException.class)
                .hasMessage(ErrorCatalog.BAD_REQUEST.getMessage());
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

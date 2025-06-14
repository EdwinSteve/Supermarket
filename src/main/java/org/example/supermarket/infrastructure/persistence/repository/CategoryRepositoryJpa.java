package org.example.supermarket.infrastructure.persistence.repository;

import org.example.supermarket.infrastructure.persistence.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositoryJpa extends JpaRepository<CategoryEntity, Integer> {
}

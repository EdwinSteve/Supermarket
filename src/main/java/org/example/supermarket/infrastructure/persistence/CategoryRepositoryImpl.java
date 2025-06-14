package org.example.supermarket.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.example.supermarket.application.port.out.CategoryRepository;
import org.example.supermarket.domain.pojos.Category;
import org.example.supermarket.infrastructure.persistence.mapper.CategoryMapper;
import org.example.supermarket.infrastructure.persistence.repository.CategoryRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryRepositoryJpa repositoryJpa;
    private final CategoryMapper mapper;

    @Override
    public List<Category> findAll() {
        return mapper.toCategoryList(repositoryJpa.findAll());
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return repositoryJpa.findById(id)
                .map(mapper::toCategory);
    }

    @Override
    public Category save(Category category) {
        return mapper.toCategory(
                repositoryJpa.save(mapper.toEntity(category)));
    }

    @Override
    public void deleteById(Integer id) {
        repositoryJpa.deleteById(id);
    }
}

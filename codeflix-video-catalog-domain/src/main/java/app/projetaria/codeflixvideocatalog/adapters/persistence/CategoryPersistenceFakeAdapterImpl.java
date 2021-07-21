package app.projetaria.codeflixvideocatalog.adapters.persistence;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.ports.persistence.CategoryPersistence;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Profile({"test"})
@Repository
public class CategoryPersistenceFakeAdapterImpl implements CategoryPersistence {

    Map<UUID, Category> categories = new HashMap<>();

    public CategoryPersistenceFakeAdapterImpl() {

        Category activeCategory = Category.builder()
                .code(UUID.fromString("ec98e83a-e26e-40c4-8b7e-82697dd71841"))
                .name("Categoria ativa")
                .description("Descrição categoria ativa")
                .isActive(Boolean.TRUE)
                .createdAt(LocalDateTime.now())
                .build();

        Category inactiveCategory = Category.builder()
                .code(UUID.fromString("9f0b248e-df2e-4d6c-b6e2-1f52a6cde125"))
                .name("Categoria inativa")
                .description("Descrição categoria inativa")
                .isActive(Boolean.FALSE)
                .createdAt(LocalDateTime.now())
                .deletedAt(LocalDateTime.now())
                .build();

        categories.put(activeCategory.getCode(), activeCategory);
        categories.put(inactiveCategory.getCode(), inactiveCategory);
    }

    @Override
    public Category get(UUID code) {
        return categories.get(code);
    }

    @Override
    public List<Category> list() {
        return new ArrayList<>(categories.values()).stream()
                .filter(category -> category.getIsActive().equals(Boolean.TRUE))
                .collect(Collectors.toList());
    }

    @Override
    public List<Category> listOnlyTrashed() {
        return new ArrayList<>(categories.values()).stream()
                .filter(category -> category.getIsActive().equals(Boolean.FALSE))
                .collect(Collectors.toList());
    }

    @Override
    public List<Category> listWithTrashed() {
        return new ArrayList<>(categories.values());
    }

    @Override
    public Category save(Category category) {
        category.setCode(UUID.randomUUID());
        category.setCreatedAt(LocalDateTime.now());

        categories.put(category.getCode(), category);
        return category;
    }

    @Override
    public void delete(Category category) {
        categories.remove(category.getCode());
    }

    @Override
    public void active(Category category) {
        categories.replace(category.getCode(), category);
    }

    @Override
    public void inactive(Category category) {
        categories.replace(category.getCode(), category);
    }
}

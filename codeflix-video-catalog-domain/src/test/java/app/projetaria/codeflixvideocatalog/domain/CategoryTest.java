package app.projetaria.codeflixvideocatalog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Regras de categorias")
public class CategoryTest {

    private Category category;

    @BeforeEach
    public void prepare() {
        this.category = category.builder()
                .code(UUID.randomUUID())
                .name("Category test")
                .description("Description category")
                .isActive(Boolean.TRUE)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .deletedAt(null)
                .build();
    }

    @Test
    @DisplayName("Verifica se uma categoria é ativada")
    public void shouldBeActiveCategory() {
        this.category.setIsActive(Boolean.FALSE);

        this.category.active();

        assertTrue(this.category.getIsActive());
    }

    @Test
    @DisplayName("Verifica se uma categoria é ativada")
    public void shouldBeInactiveCategory() {
        this.category.setIsActive(Boolean.TRUE);

        this.category.inactive();

        assertFalse(this.category.getIsActive());
    }

    @Test
    @DisplayName("Verifica se setters, getters e construtores estão corretos")
    public void shouldBeCorrectCategory() {

        UUID code = UUID.randomUUID();
        String name = "Category name";
        String description = "Category description";
        Boolean isActive = Boolean.TRUE;
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();
        LocalDateTime deletedAt = LocalDateTime.now();

        Category categoryWithNoArgs = new Category();

        categoryWithNoArgs.setCode(code);
        categoryWithNoArgs.setName(name);
        categoryWithNoArgs.setDescription(description);
        categoryWithNoArgs.setIsActive(isActive);
        categoryWithNoArgs.setCreatedAt(createdAt);
        categoryWithNoArgs.setUpdatedAt(updatedAt);
        categoryWithNoArgs.setDeletedAt(deletedAt);

        Category categoryWithArgs = new Category(code, name, description, isActive, createdAt, updatedAt, deletedAt);

        assertEquals(code, categoryWithNoArgs.getCode());
        assertEquals(name, categoryWithNoArgs.getName());
        assertEquals(description, categoryWithNoArgs.getDescription());
        assertEquals(isActive, categoryWithNoArgs.getIsActive());
        assertEquals(createdAt, categoryWithNoArgs.getCreatedAt());
        assertEquals(updatedAt, categoryWithNoArgs.getUpdatedAt());
        assertEquals(deletedAt, categoryWithNoArgs.getDeletedAt());

        assertEquals(code, categoryWithArgs.getCode());
        assertEquals(name, categoryWithArgs.getName());
        assertEquals(description, categoryWithArgs.getDescription());
        assertEquals(isActive, categoryWithArgs.getIsActive());
        assertEquals(createdAt, categoryWithArgs.getCreatedAt());
        assertEquals(updatedAt, categoryWithArgs.getUpdatedAt());
        assertEquals(deletedAt, categoryWithArgs.getDeletedAt());

    }
}

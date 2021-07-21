package app.projetaria.codeflixvideocatalog.ports.persistence;

import app.projetaria.codeflixvideocatalog.domain.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryPersistence {

    Category get(UUID code);

    List<Category> list();

    List<Category> listOnlyTrashed();

    List<Category> listWithTrashed();

    Category save(Category category);

    void delete(Category category);

    void active(Category category);

    void inactive(Category category);
}

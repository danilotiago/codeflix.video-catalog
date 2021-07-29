package app.projetaria.codeflixvideocatalog.ports.usecase;

import app.projetaria.codeflixvideocatalog.domain.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryManagerUseCase {

    Category get(UUID code);

    List<Category> list();

    List<Category> listWithTrashed();

    List<Category> listOnlyTrashed();

    Category save(Category category);

    void delete(UUID code);
}

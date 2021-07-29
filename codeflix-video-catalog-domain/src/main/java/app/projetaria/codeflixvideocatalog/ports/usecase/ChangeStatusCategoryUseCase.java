package app.projetaria.codeflixvideocatalog.ports.usecase;

import app.projetaria.codeflixvideocatalog.domain.Category;

public interface ChangeStatusCategoryUseCase {

    void active(Category category);

    void inactive(Category category);
}

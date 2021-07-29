package app.projetaria.codeflixvideocatalog.usecase;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.exceptions.BusinessException;
import app.projetaria.codeflixvideocatalog.messages.ErrorMessages;
import app.projetaria.codeflixvideocatalog.ports.persistence.CategoryPersistence;
import app.projetaria.codeflixvideocatalog.ports.usecase.ChangeStatusCategoryUseCase;
import app.projetaria.codeflixvideocatalog.services.ChangeStatusCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ChangeStatusCategoryUseCaseImpl implements ChangeStatusCategoryUseCase {

    @Autowired
    private CategoryPersistence persistence;

    @Autowired
    private ChangeStatusCategoryService service;

    @Override
    public void active(Category category) {
        if (isNull(category)) {
            throw new BusinessException(ErrorMessages.CATEGORY_REQUIRED);
        }

        this.service.active(category);
        this.persistence.active(category);
    }

    @Override
    public void inactive(Category category) {
        if (isNull(category)) {
            throw new BusinessException(ErrorMessages.CATEGORY_REQUIRED);
        }

        this.service.inactive(category);
        this.persistence.inactive(category);
    }
}

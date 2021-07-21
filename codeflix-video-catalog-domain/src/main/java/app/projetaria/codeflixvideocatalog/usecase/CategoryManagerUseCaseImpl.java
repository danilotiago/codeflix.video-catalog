package app.projetaria.codeflixvideocatalog.usecase;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.exceptions.BusinessException;
import app.projetaria.codeflixvideocatalog.messages.ErrorMessages;
import app.projetaria.codeflixvideocatalog.ports.persistence.CategoryPersistence;
import app.projetaria.codeflixvideocatalog.ports.usecase.CategoryManagerUseCase;
import app.projetaria.codeflixvideocatalog.services.CategoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Component
public class CategoryManagerUseCaseImpl implements CategoryManagerUseCase {

    @Autowired
    private CategoryPersistence persistence;

    @Autowired
    private CategoryManagerService service;

    @Override
    public Category get(UUID code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.CATEGORY_CODE_REQUIRED);
        }
        return this.persistence.get(code);
    }

    @Override
    public List<Category> list() {
        return this.persistence.list();
    }

    @Override
    public List<Category> listWithTrashed() {
        return this.persistence.listWithTrashed();
    }

    @Override
    public List<Category> listOnlyTrashed() {
        return this.persistence.listOnlyTrashed();
    }

    @Override
    public Category save(Category category) {
        if (isNull(category)) {
            throw new BusinessException(ErrorMessages.CATEGORY_REQUIRED);
        }

        return this.persistence.save(category);
    }

    @Override
    public void delete(UUID code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.CATEGORY_REQUIRED);
        }

        Category categoryFounded = this.get(code);

        if (isNull(categoryFounded)) {
            throw new BusinessException(ErrorMessages.CATEGORY_NOT_FOUND);
        }

        this.persistence.delete(categoryFounded);
    }

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

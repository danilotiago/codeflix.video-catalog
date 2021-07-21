package app.projetaria.codeflixvideocatalog.services;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.exceptions.BusinessException;
import app.projetaria.codeflixvideocatalog.messages.ErrorMessages;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class CategoryManagerService {

    public void active(Category category) {
        if (isNull(category)) {
            throw new BusinessException(ErrorMessages.CATEGORY_REQUIRED);
        }

        category.active();
    }

    public void inactive(Category category) {
        if (isNull(category)) {
            throw new BusinessException(ErrorMessages.CATEGORY_REQUIRED);
        }

        category.inactive();
    }

}

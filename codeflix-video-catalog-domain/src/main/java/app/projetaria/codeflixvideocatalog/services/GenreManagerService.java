package app.projetaria.codeflixvideocatalog.services;

import app.projetaria.codeflixvideocatalog.domain.Genre;
import app.projetaria.codeflixvideocatalog.exceptions.BusinessException;
import app.projetaria.codeflixvideocatalog.messages.ErrorMessages;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class GenreManagerService {

    public void active(Genre genre) {
        if (isNull(genre)) {
            throw new BusinessException(ErrorMessages.GENRE_REQUIRED);
        }

        genre.active();
    }

    public void inactive(Genre genre) {
        if (isNull(genre)) {
            throw new BusinessException(ErrorMessages.GENRE_REQUIRED);
        }

        genre.inactive();
    }

}

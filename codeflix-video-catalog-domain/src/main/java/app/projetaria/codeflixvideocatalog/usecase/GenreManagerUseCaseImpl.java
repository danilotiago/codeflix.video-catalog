package app.projetaria.codeflixvideocatalog.usecase;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.domain.Genre;
import app.projetaria.codeflixvideocatalog.exceptions.BusinessException;
import app.projetaria.codeflixvideocatalog.messages.ErrorMessages;
import app.projetaria.codeflixvideocatalog.ports.persistence.GenrePersistence;
import app.projetaria.codeflixvideocatalog.ports.usecase.GenreManagerUseCase;
import app.projetaria.codeflixvideocatalog.services.GenreManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Component
public class GenreManagerUseCaseImpl implements GenreManagerUseCase {

    @Autowired
    private GenrePersistence persistence;

    @Autowired
    private GenreManagerService service;

    @Override
    public Genre get(UUID code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.GENRE_CODE_REQUIRED);
        }
        return this.persistence.get(code);
    }

    @Override
    public List<Genre> list() {
        return this.persistence.list();
    }

    @Override
    public List<Genre> listWithTrashed() {
        return this.persistence.listWithTrashed();
    }

    @Override
    public List<Genre> listOnlyTrashed() {
        return this.persistence.listOnlyTrashed();
    }

    @Override
    public Genre save(Genre genre) {
        if (isNull(genre)) {
            throw new BusinessException(ErrorMessages.GENRE_REQUIRED);
        }

        return this.persistence.save(genre);
    }

    @Override
    public void delete(UUID code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.GENRE_REQUIRED);
        }

        Genre genreFounded = this.get(code);

        if (isNull(genreFounded)) {
            throw new BusinessException(ErrorMessages.GENRE_NOT_FOUND);
        }

        this.persistence.delete(genreFounded);
    }

    @Override
    public void active(Genre genre) {
        if (isNull(genre)) {
            throw new BusinessException(ErrorMessages.GENRE_REQUIRED);
        }

        this.service.active(genre);
        this.persistence.active(genre);
    }

    @Override
    public void inactive(Genre genre) {
        if (isNull(genre)) {
            throw new BusinessException(ErrorMessages.GENRE_REQUIRED);
        }

        this.service.inactive(genre);
        this.persistence.inactive(genre);
    }
}

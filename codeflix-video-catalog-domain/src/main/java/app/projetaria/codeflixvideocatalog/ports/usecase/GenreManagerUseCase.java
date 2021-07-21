package app.projetaria.codeflixvideocatalog.ports.usecase;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.domain.Genre;

import java.util.List;
import java.util.UUID;

public interface GenreManagerUseCase {

    Genre get(UUID code);

    List<Genre> list();

    List<Genre> listWithTrashed();

    List<Genre> listOnlyTrashed();

    Genre save(Genre genre);

    void delete(UUID code);

    void active(Genre genre);

    void inactive(Genre genre);
}

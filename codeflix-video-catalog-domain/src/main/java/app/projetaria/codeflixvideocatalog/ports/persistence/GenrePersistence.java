package app.projetaria.codeflixvideocatalog.ports.persistence;

import app.projetaria.codeflixvideocatalog.domain.Genre;

import java.util.List;
import java.util.UUID;

public interface GenrePersistence {

    Genre get(UUID code);

    List<Genre> list();

    List<Genre> listOnlyTrashed();

    List<Genre> listWithTrashed();

    Genre save(Genre genre);

    void delete(Genre genre);

    void active(Genre genre);

    void inactive(Genre genre);
}

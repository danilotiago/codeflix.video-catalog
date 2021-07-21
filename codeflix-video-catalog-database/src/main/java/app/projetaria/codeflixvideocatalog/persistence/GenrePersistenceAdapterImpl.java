package app.projetaria.codeflixvideocatalog.persistence;

import app.projetaria.codeflixvideocatalog.domain.Genre;
import app.projetaria.codeflixvideocatalog.entity.GenreEntity;
import app.projetaria.codeflixvideocatalog.mapper.GenreEntityMapper;
import app.projetaria.codeflixvideocatalog.ports.persistence.GenrePersistence;
import app.projetaria.codeflixvideocatalog.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class GenrePersistenceAdapterImpl implements GenrePersistence {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private GenreRepository repository;

    @Override
    public Genre get(UUID code) {
        Optional<GenreEntity> result = this.repository.findById(code);
        if (result.isPresent()) {
            return GenreEntityMapper.INSTANCE.from(result.get());
        }
        return null;
    }

    @Override
    public List<Genre> list() {
        List<GenreEntity> genres = this.repository.findByDeletedAtNull();
        return GenreEntityMapper.INSTANCE.from(genres);
    }

    @Override
    public List<Genre> listOnlyTrashed() {
        List<GenreEntity> genres =  this.repository.findByDeletedAtNotNull();

        return GenreEntityMapper.INSTANCE.from(genres);
    }

    @Override
    public List<Genre> listWithTrashed() {
        List<Genre> genres = this.list();
        genres.addAll(this.listOnlyTrashed());

        return genres;
    }

    @Override
    public Genre save(Genre genre) {
        GenreEntity genreEntity = GenreEntityMapper.INSTANCE.from(genre);
        genreEntity = this.repository.save(genreEntity);
        return GenreEntityMapper.INSTANCE.from(genreEntity);
    }

    @Override
    public void delete(Genre genre) {
        this.repository.deleteById(genre.getCode());
    }

    @Override
    public void active(Genre genre) {
        this.save(genre);
    }

    @Override
    public void inactive(Genre genre) {
        this.save(genre);
    }
}

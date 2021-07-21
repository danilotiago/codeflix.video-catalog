package app.projetaria.codeflixvideocatalog.adapters.persistence;

import app.projetaria.codeflixvideocatalog.domain.Genre;
import app.projetaria.codeflixvideocatalog.ports.persistence.GenrePersistence;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Profile({"test"})
@Repository
public class GenrePersistenceFakeAdapterImpl implements GenrePersistence {

    Map<UUID, Genre> genres = new HashMap<>();

    public GenrePersistenceFakeAdapterImpl() {

        Genre activeGenre = Genre.builder()
                .code(UUID.fromString("ec98e83a-e26e-40c4-8b7e-82697dd71841"))
                .name("Gênero ativo")
                .isActive(Boolean.TRUE)
                .createdAt(LocalDateTime.now())
                .build();

        Genre inactiveGenre = Genre.builder()
                .code(UUID.fromString("9f0b248e-df2e-4d6c-b6e2-1f52a6cde125"))
                .name("Gênero inativo")
                .isActive(Boolean.FALSE)
                .createdAt(LocalDateTime.now())
                .deletedAt(LocalDateTime.now())
                .build();

        genres.put(activeGenre.getCode(), activeGenre);
        genres.put(inactiveGenre.getCode(), inactiveGenre);
    }

    @Override
    public Genre get(UUID code) {
        return genres.get(code);
    }

    @Override
    public List<Genre> list() {
        return new ArrayList<>(genres.values()).stream()
                .filter(genre -> genre.getIsActive().equals(Boolean.TRUE))
                .collect(Collectors.toList());
    }

    @Override
    public List<Genre> listOnlyTrashed() {
        return new ArrayList<>(genres.values()).stream()
                .filter(genre -> genre.getIsActive().equals(Boolean.FALSE))
                .collect(Collectors.toList());
    }

    @Override
    public List<Genre> listWithTrashed() {
        return new ArrayList<>(genres.values());
    }

    @Override
    public Genre save(Genre genre) {
        genre.setCode(UUID.randomUUID());
        genre.setCreatedAt(LocalDateTime.now());

        genres.put(genre.getCode(), genre);
        return genre;
    }

    @Override
    public void delete(Genre genre) {
        genres.remove(genre.getCode());
    }

    @Override
    public void active(Genre genre) {
        genres.replace(genre.getCode(), genre);
    }

    @Override
    public void inactive(Genre genre) {
        genres.replace(genre.getCode(), genre);
    }
}

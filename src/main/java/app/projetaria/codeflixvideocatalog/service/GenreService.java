package app.projetaria.codeflixvideocatalog.service;

import app.projetaria.codeflixvideocatalog.entity.Genre;
import app.projetaria.codeflixvideocatalog.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    public List<Genre> list() {
        return this.repository.findAll();
    }

    public Genre find(UUID code) {
        return this.repository.findById(code).orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado com o código " + code));
    }

    public Genre save(Genre genre) {
        return this.repository.save(genre);
    }

    public void delete(UUID code) {
        this.repository.deleteById(code);
    }
}

package app.projetaria.codeflixvideocatalog.service;

import app.projetaria.codeflixvideocatalog.entity.Category;
import app.projetaria.codeflixvideocatalog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> list() {
        return this.repository.findAll();
    }

    public Category find(UUID code) {
        return this.repository.findById(code).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com o código " + code));
    }

    public Category save(Category category) {
        return this.repository.save(category);
    }

    public void delete(UUID code) {
        this.repository.deleteById(code);
    }
}

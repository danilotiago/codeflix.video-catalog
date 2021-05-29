package app.projetaria.codeflixvideocatalog.controller;

import app.projetaria.codeflixvideocatalog.dto.CategoryRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.CategoryResponseDTO;
import app.projetaria.codeflixvideocatalog.entity.Category;
import app.projetaria.codeflixvideocatalog.mapper.CategoryMapper;
import app.projetaria.codeflixvideocatalog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> list() {

        return null;
    }

    @GetMapping("/{code}")
    public ResponseEntity<CategoryResponseDTO> find(@PathVariable UUID code) {

        Category category = repository.findById(code).get();

        return null;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> save(@Valid @RequestBody CategoryRequestDTO data) {

        Category category = CategoryMapper.INSTANCE.from(data);

        return null;
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable UUID code) {
        this.repository.deleteById(code); // caso nao exista => org.springframework.dao.EmptyResultDataAccessException
    }
}

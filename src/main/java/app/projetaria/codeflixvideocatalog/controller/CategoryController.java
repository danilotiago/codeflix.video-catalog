package app.projetaria.codeflixvideocatalog.controller;

import app.projetaria.codeflixvideocatalog.dto.CategoryRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.CategoryResponseDTO;
import app.projetaria.codeflixvideocatalog.entity.Category;
import app.projetaria.codeflixvideocatalog.mapper.CategoryMapper;
import app.projetaria.codeflixvideocatalog.repository.CategoryRepository;
import app.projetaria.codeflixvideocatalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> list() {
        List<CategoryResponseDTO> response = CategoryMapper.INSTANCE.from(this.service.list());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CategoryResponseDTO> find(@PathVariable UUID code) {
        CategoryResponseDTO response = CategoryMapper.INSTANCE.from(this.service.find(code));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> save(@Valid @RequestBody CategoryRequestDTO data) {
        Category category = CategoryMapper.INSTANCE.from(data);
        CategoryResponseDTO response = CategoryMapper.INSTANCE.from(this.service.save(category));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID code) {
        this.service.delete(code);
    }
}

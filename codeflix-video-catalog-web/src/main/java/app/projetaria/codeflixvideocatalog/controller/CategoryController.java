package app.projetaria.codeflixvideocatalog.controller;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.dto.CategoryRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.CategoryResponseDTO;
import app.projetaria.codeflixvideocatalog.mapper.CategoryMapper;
import app.projetaria.codeflixvideocatalog.ports.usecase.CategoryManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryManagerUseCase categoryManagerUseCase;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> list(
            @RequestParam(name = "only_deleted", required = false) Boolean onlyDeleted,
            @RequestParam(name = "with_deleted", required = false) Boolean withDeleted) {

        List<CategoryResponseDTO> response = null;

        if (! isNull(onlyDeleted) && onlyDeleted == true) {
            response = CategoryMapper.INSTANCE.from(this.categoryManagerUseCase.listOnlyTrashed());
        } else if (! isNull(withDeleted) && withDeleted == true) {
            response = CategoryMapper.INSTANCE.from(this.categoryManagerUseCase.listWithTrashed());
        } else {
            response = CategoryMapper.INSTANCE.from(this.categoryManagerUseCase.list());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CategoryResponseDTO> find(@PathVariable UUID code) {
        CategoryResponseDTO response = CategoryMapper.INSTANCE.from(this.categoryManagerUseCase.get(code));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> save(@Valid @RequestBody CategoryRequestDTO data) {
        Category category = CategoryMapper.INSTANCE.from(data);
        CategoryResponseDTO response = CategoryMapper.INSTANCE.from(this.categoryManagerUseCase.save(category));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID code) {
        this.categoryManagerUseCase.delete(code);
    }
}

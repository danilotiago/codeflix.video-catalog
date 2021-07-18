package app.projetaria.codeflixvideocatalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    // categoryUseCase
//    @Autowired
//    private CategoryService service;

//    @GetMapping
//    public ResponseEntity<List<CategoryResponseDTO>> list() {
//        List<CategoryResponseDTO> response = CategoryMapper.INSTANCE.from(this.service.list());
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{code}")
//    public ResponseEntity<CategoryResponseDTO> find(@PathVariable UUID code) {
//        CategoryResponseDTO response = CategoryMapper.INSTANCE.from(this.service.find(code));
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping
//    public ResponseEntity<CategoryResponseDTO> save(@Valid @RequestBody CategoryRequestDTO data) {
//        Category category = CategoryMapper.INSTANCE.from(data);
//        CategoryResponseDTO response = CategoryMapper.INSTANCE.from(this.service.save(category));
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
//
//    @DeleteMapping("/{code}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable UUID code) {
//        this.service.delete(code);
//    }
}

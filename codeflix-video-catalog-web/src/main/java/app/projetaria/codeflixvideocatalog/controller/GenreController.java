package app.projetaria.codeflixvideocatalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/genres")
public class GenreController {

//      genreUseCase
//    @Autowired
//    private GenreService service;
//
//    @GetMapping
//    public ResponseEntity<List<GenreResponseDTO>> list() {
//        List<GenreResponseDTO> response = GenreMapper.INSTANCE.from(this.service.list());
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{code}")
//    public ResponseEntity<GenreResponseDTO> find(@PathVariable UUID code) {
//        GenreResponseDTO response = GenreMapper.INSTANCE.from(this.service.find(code));
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping
//    public ResponseEntity<GenreResponseDTO> save(@Valid @RequestBody GenreRequestDTO data) {
//        Genre genre = GenreMapper.INSTANCE.from(data);
//        GenreResponseDTO response = GenreMapper.INSTANCE.from(this.service.save(genre));
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
//
//    @DeleteMapping("/{code}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable UUID code) {
//        this.service.delete(code);
//    }

}

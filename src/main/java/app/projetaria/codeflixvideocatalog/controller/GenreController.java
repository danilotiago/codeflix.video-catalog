package app.projetaria.codeflixvideocatalog.controller;

import app.projetaria.codeflixvideocatalog.dto.GenreRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.GenreResponseDTO;
import app.projetaria.codeflixvideocatalog.dto.GenreResponseDTO;
import app.projetaria.codeflixvideocatalog.entity.Genre;
import app.projetaria.codeflixvideocatalog.mapper.GenreMapper;
import app.projetaria.codeflixvideocatalog.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/genres")
public class GenreController {

    @Autowired
    private GenreService service;

    @GetMapping
    public ResponseEntity<List<GenreResponseDTO>> list() {
        List<GenreResponseDTO> response = GenreMapper.INSTANCE.from(this.service.list());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{code}")
    public ResponseEntity<GenreResponseDTO> find(@PathVariable UUID code) {
        GenreResponseDTO response = GenreMapper.INSTANCE.from(this.service.find(code));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GenreResponseDTO> save(@Valid @RequestBody GenreRequestDTO data) {
        Genre genre = GenreMapper.INSTANCE.from(data);
        GenreResponseDTO response = GenreMapper.INSTANCE.from(this.service.save(genre));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID code) {
        this.service.delete(code);
    }

}

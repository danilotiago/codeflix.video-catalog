package app.projetaria.codeflixvideocatalog.controller;

import app.projetaria.codeflixvideocatalog.dto.CategoryRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.GenreResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/genres")
public class GenreController {

    public ResponseEntity<List<GenreResponseDTO>> list() {
        return null;
    }

    @GetMapping("/{code}")
    public ResponseEntity<GenreResponseDTO> find(@PathVariable UUID code) {

        return null;
    }

    @PostMapping
    public ResponseEntity<GenreResponseDTO> save(@Valid @RequestBody CategoryRequestDTO data) {

        return null;
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable UUID code) {
        //this.repository.deleteById(code); // caso nao exista => org.springframework.dao.EmptyResultDataAccessException
    }

}

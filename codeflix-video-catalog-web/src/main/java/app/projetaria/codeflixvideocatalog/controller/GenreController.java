package app.projetaria.codeflixvideocatalog.controller;

import app.projetaria.codeflixvideocatalog.domain.Genre;
import app.projetaria.codeflixvideocatalog.dto.GenreRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.GenreResponseDTO;
import app.projetaria.codeflixvideocatalog.mapper.GenreMapper;
import app.projetaria.codeflixvideocatalog.ports.usecase.GenreManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/v1/genres")
public class GenreController {

    @Autowired
    private GenreManagerUseCase genreManagerUseCase;

    @GetMapping
    public ResponseEntity<List<GenreResponseDTO>> list(
            @RequestParam(name = "only_deleted", required = false) Boolean onlyDeleted,
            @RequestParam(name = "with_deleted", required = false) Boolean withDeleted) {

        List<GenreResponseDTO> response = null;

        if (! isNull(onlyDeleted) && onlyDeleted == true) {
            response = GenreMapper.INSTANCE.from(this.genreManagerUseCase.listOnlyTrashed());
        } else if (! isNull(withDeleted) && withDeleted == true) {
            response = GenreMapper.INSTANCE.from(this.genreManagerUseCase.listWithTrashed());
        } else {
            response = GenreMapper.INSTANCE.from(this.genreManagerUseCase.list());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{code}")
    public ResponseEntity<GenreResponseDTO> find(@PathVariable UUID code) {
        GenreResponseDTO response = GenreMapper.INSTANCE.from(this.genreManagerUseCase.get(code));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GenreResponseDTO> save(@RequestBody GenreRequestDTO data) {

        // aplicar fluent validator

        Genre genre = GenreMapper.INSTANCE.from(data);
        GenreResponseDTO response = GenreMapper.INSTANCE.from(this.genreManagerUseCase.save(genre));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID code) {
        this.genreManagerUseCase.delete(code);
    }
}

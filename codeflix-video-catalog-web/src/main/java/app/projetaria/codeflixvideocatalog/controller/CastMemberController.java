package app.projetaria.codeflixvideocatalog.controller;

import app.projetaria.codeflixvideocatalog.domain.CastMember;
import app.projetaria.codeflixvideocatalog.dto.CastMemberRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.CastMemberResponseDTO;
import app.projetaria.codeflixvideocatalog.mapper.CastMemberMapper;
import app.projetaria.codeflixvideocatalog.ports.usecase.CastMemberManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/v1/cast-members")
public class CastMemberController {

    @Autowired
    private CastMemberManagerUseCase castMemberManagerUseCase;

    @GetMapping
    public ResponseEntity<List<CastMemberResponseDTO>> list(
            @RequestParam(name = "only_deleted", required = false) Boolean onlyDeleted,
            @RequestParam(name = "with_deleted", required = false) Boolean withDeleted) {

        List<CastMemberResponseDTO> response = null;

        if (! isNull(onlyDeleted) && onlyDeleted == true) {
            response = CastMemberMapper.INSTANCE.from(this.castMemberManagerUseCase.listOnlyTrashed());
        } else if (! isNull(withDeleted) && withDeleted == true) {
            response = CastMemberMapper.INSTANCE.from(this.castMemberManagerUseCase.listWithTrashed());
        } else {
            response = CastMemberMapper.INSTANCE.from(this.castMemberManagerUseCase.list());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CastMemberResponseDTO> find(@PathVariable UUID code) {
        CastMemberResponseDTO response = CastMemberMapper.INSTANCE.from(this.castMemberManagerUseCase.get(code));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CastMemberResponseDTO> save(@Valid @RequestBody CastMemberRequestDTO data) {
        CastMember castMember = CastMemberMapper.INSTANCE.from(data);
        CastMemberResponseDTO response = CastMemberMapper.INSTANCE.from(this.castMemberManagerUseCase.save(castMember));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID code) {
        this.castMemberManagerUseCase.delete(code);
    }
}

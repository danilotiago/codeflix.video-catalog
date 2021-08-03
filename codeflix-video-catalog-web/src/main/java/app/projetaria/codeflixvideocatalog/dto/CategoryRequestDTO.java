package app.projetaria.codeflixvideocatalog.dto;

import app.projetaria.codeflixvideocatalog.constraint.annotation.MustOnlyHaveLetters;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryRequestDTO {

    @JsonProperty("name")
    @NotNull(message = "O nome é obrigatório")
    private String name;

    @JsonProperty("description")
    @MustOnlyHaveLetters(message = "A descrição deve possuir apenas letras")
    private String description;

    @JsonProperty("is_active")
    @NotNull(message = "O status da categoria é obrigatório")
    private Boolean isActive;
}

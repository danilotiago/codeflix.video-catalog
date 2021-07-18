package app.projetaria.codeflixvideocatalog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreRequestDTO {

    // aplicar fluent validator
//    @NotNull(message = "O nome do gênero é obrigatório")
//    @Size(min = 3, max = 255, message = "O nome do gênero deve conter no mínimo 3 e no máximo 255 caracteres")
//    private String name;
//
//    @JsonProperty("is_active")
//    @NotNull(message = "O status do gênero é obrigatório")
//    private Boolean isActive;
}

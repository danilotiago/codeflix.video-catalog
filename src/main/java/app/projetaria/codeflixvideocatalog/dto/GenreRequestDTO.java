package app.projetaria.codeflixvideocatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class GenreRequestDTO {

    @NotNull(message = "O nome do gênero é obrigatório")
    @Size(min = 3, max = 255, message = "O nome do gênero deve conter no mínimo 3 e no máximo 255 caracteres")
    private String name;

    @JsonProperty("is_active")
    @NotNull(message = "O status do gênero é obrigatório")
    private Boolean isActive;
}

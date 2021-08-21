package app.projetaria.codeflixvideocatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CastMemberRequestDTO {

    @JsonProperty("name")
    @NotNull(message = "O nome é obrigatório")
    private String name;

    @JsonProperty("position")
    @NotNull(message = "A posição do membro do elenco é obrigatório")
    private String position;

    @JsonProperty("is_active")
    @NotNull(message = "O status da membro de elenco é obrigatório")
    private Boolean isActive;
}

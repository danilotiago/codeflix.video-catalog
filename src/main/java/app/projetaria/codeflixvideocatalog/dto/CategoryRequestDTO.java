package app.projetaria.codeflixvideocatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class CategoryRequestDTO {

    @NotNull(message = "O nome da categoria é obrigatório")
    @Size(min = 3, max = 100, message = "O nome da categoria deve conter no mínimo 3 e no máximo 100 caracteres")
    private String name;

    private String description;

    @JsonProperty("is_active")
    @NotNull(message = "O status da categoria é obrigatório")
    private Boolean isActive;
}

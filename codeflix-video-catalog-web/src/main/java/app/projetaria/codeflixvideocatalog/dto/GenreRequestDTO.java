package app.projetaria.codeflixvideocatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreRequestDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("is_active")
    private Boolean isActive;
}

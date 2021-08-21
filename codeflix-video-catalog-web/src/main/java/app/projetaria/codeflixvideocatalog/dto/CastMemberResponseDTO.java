package app.projetaria.codeflixvideocatalog.dto;

import app.projetaria.codeflixvideocatalog.enums.CastMemberPosition;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CastMemberResponseDTO {

    @JsonProperty("code")
    private UUID code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("position")
    private CastMemberPosition position;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("deleted_at")
    private LocalDateTime deletedAt;
}

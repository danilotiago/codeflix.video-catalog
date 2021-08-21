package app.projetaria.codeflixvideocatalog.domain;

import app.projetaria.codeflixvideocatalog.enums.CastMemberPosition;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CastMember {

    private UUID code;

    private String name;

    private CastMemberPosition position;

    private Boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public void active() {
        this.isActive = Boolean.TRUE;
    }

    public void inactive() {
        this.isActive = Boolean.FALSE;
    }
}

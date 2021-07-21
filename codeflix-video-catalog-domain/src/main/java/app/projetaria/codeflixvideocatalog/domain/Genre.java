package app.projetaria.codeflixvideocatalog.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {

    private UUID code;

    private String name;

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

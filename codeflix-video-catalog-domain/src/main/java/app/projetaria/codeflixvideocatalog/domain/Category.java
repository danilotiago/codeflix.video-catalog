package app.projetaria.codeflixvideocatalog.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    private UUID code;

    private String name;

    private String description;

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


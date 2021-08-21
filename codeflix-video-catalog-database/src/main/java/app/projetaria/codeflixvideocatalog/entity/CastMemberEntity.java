package app.projetaria.codeflixvideocatalog.entity;

import app.projetaria.codeflixvideocatalog.enums.CastMemberPosition;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@SQLDelete(sql = "UPDATE cast_members SET deleted_at = NOW() WHERE code = ?")
@Entity(name = "cast_members")
public class CastMemberEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID code;

    private String name;

    @Enumerated(EnumType.STRING)
    private CastMemberPosition position;

    private Boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @PrePersist
    private void beforePersist() {
        setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    private void beforeUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }
}

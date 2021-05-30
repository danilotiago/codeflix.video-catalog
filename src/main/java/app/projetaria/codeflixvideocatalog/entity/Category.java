package app.projetaria.codeflixvideocatalog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE categories SET deleted_at = NOW() WHERE code = ?")
@Entity(name = "categories")
public class Category {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID code;

    private String name;
    private String description;

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

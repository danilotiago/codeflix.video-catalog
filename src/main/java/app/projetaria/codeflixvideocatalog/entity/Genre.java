package app.projetaria.codeflixvideocatalog.entity;

import app.projetaria.codeflixvideocatalog.listener.TimestampsListener;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@EntityListeners({ TimestampsListener.class })
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql = "UPDATE genres SET deleted_at = NOW() WHERE code = ?")
@Entity(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID code;

    private String name;

    private Boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

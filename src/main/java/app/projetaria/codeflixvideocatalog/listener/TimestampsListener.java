package app.projetaria.codeflixvideocatalog.listener;

import app.projetaria.codeflixvideocatalog.entity.Category;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class TimestampsListener {

    @PrePersist
    private void beforePersist(Category category) {
        category.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    private void beforeUpdate(Category category) {
        category.setUpdatedAt(LocalDateTime.now());
    }
}

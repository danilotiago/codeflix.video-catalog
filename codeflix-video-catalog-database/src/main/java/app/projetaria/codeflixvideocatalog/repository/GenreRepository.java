package app.projetaria.codeflixvideocatalog.repository;

import app.projetaria.codeflixvideocatalog.entity.CategoryEntity;
import app.projetaria.codeflixvideocatalog.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, UUID> {

    List<GenreEntity> findByDeletedAtNotNull();

    List<GenreEntity> findByDeletedAtNull();
}

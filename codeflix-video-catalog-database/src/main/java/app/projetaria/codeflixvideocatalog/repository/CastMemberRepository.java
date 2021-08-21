package app.projetaria.codeflixvideocatalog.repository;

import app.projetaria.codeflixvideocatalog.entity.CastMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CastMemberRepository extends JpaRepository<CastMemberEntity, UUID> {

    List<CastMemberEntity> findByDeletedAtNotNull();

    List<CastMemberEntity> findByDeletedAtNull();
}

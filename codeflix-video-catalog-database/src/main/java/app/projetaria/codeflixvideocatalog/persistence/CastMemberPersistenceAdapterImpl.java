package app.projetaria.codeflixvideocatalog.persistence;

import app.projetaria.codeflixvideocatalog.domain.CastMember;
import app.projetaria.codeflixvideocatalog.entity.CastMemberEntity;
import app.projetaria.codeflixvideocatalog.mapper.CastMemberEntityMapper;
import app.projetaria.codeflixvideocatalog.ports.persistence.CastMemberPersistence;
import app.projetaria.codeflixvideocatalog.repository.CastMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CastMemberPersistenceAdapterImpl implements CastMemberPersistence {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CastMemberRepository repository;

    @Override
    public CastMember get(UUID code) {
        Optional<CastMemberEntity> result = this.repository.findById(code);
        if (result.isPresent()) {
            return CastMemberEntityMapper.INSTANCE.from(result.get());
        }
        return null;
    }

    @Override
    public List<CastMember> list() {
        List<CastMemberEntity> castMembers = this.repository.findByDeletedAtNull();
        return CastMemberEntityMapper.INSTANCE.from(castMembers);
    }

    @Override
    public List<CastMember> listOnlyTrashed() {
        List<CastMemberEntity> castMembers =  this.repository.findByDeletedAtNotNull();

        return CastMemberEntityMapper.INSTANCE.from(castMembers);
    }

    @Override
    public List<CastMember> listWithTrashed() {
        List<CastMember> castMembers = this.list();
        castMembers.addAll(this.listOnlyTrashed());

        return castMembers;
    }

    @Override
    public CastMember save(CastMember castMember) {
        CastMemberEntity castMemberEntity = CastMemberEntityMapper.INSTANCE.from(castMember);
        castMemberEntity = this.repository.save(castMemberEntity);
        return CastMemberEntityMapper.INSTANCE.from(castMemberEntity);
    }

    @Override
    public void delete(CastMember castMember) {
        this.repository.deleteById(castMember.getCode());
    }

    @Override
    public void active(CastMember castMember) {
        this.save(castMember);
    }

    @Override
    public void inactive(CastMember castMember) {
        this.save(castMember);
    }
}

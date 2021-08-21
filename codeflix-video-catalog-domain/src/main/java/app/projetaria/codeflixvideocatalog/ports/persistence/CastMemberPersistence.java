package app.projetaria.codeflixvideocatalog.ports.persistence;

import app.projetaria.codeflixvideocatalog.domain.CastMember;

import java.util.List;
import java.util.UUID;

public interface CastMemberPersistence {

    CastMember get(UUID code);

    List<CastMember> list();

    List<CastMember> listOnlyTrashed();

    List<CastMember> listWithTrashed();

    CastMember save(CastMember castMember);

    void delete(CastMember castMember);

    void active(CastMember castMember);

    void inactive(CastMember castMember);
}

package app.projetaria.codeflixvideocatalog.ports.usecase;

import app.projetaria.codeflixvideocatalog.domain.CastMember;

import java.util.List;
import java.util.UUID;

public interface CastMemberManagerUseCase {

    CastMember get(UUID code);

    List<CastMember> list();

    List<CastMember> listWithTrashed();

    List<CastMember> listOnlyTrashed();

    CastMember save(CastMember castMember);

    void delete(UUID code);
}

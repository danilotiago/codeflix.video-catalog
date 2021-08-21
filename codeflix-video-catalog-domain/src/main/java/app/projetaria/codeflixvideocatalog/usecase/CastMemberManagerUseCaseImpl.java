package app.projetaria.codeflixvideocatalog.usecase;

import app.projetaria.codeflixvideocatalog.domain.CastMember;
import app.projetaria.codeflixvideocatalog.exceptions.BusinessException;
import app.projetaria.codeflixvideocatalog.messages.ErrorMessages;
import app.projetaria.codeflixvideocatalog.ports.persistence.CastMemberPersistence;
import app.projetaria.codeflixvideocatalog.ports.usecase.CastMemberManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Component
public class CastMemberManagerUseCaseImpl implements CastMemberManagerUseCase {

    @Autowired
    private CastMemberPersistence persistence;

    @Override
    public CastMember get(UUID code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.CAST_MEMBER_CODE_REQUIRED);
        }
        return this.persistence.get(code);
    }

    @Override
    public List<CastMember> list() {
        return this.persistence.list();
    }

    @Override
    public List<CastMember> listWithTrashed() {
        return this.persistence.listWithTrashed();
    }

    @Override
    public List<CastMember> listOnlyTrashed() {
        return this.persistence.listOnlyTrashed();
    }

    @Override
    public CastMember save(CastMember castMember) {
        if (isNull(castMember)) {
            throw new BusinessException(ErrorMessages.CAST_MEMBER_REQUIRED);
        }

        return this.persistence.save(castMember);
    }

    @Override
    public void delete(UUID code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.CAST_MEMBER_REQUIRED);
        }

        CastMember castMemberFounded = this.get(code);

        if (isNull(castMemberFounded)) {
            throw new BusinessException(ErrorMessages.CAST_MEMBER_NOT_FOUND);
        }

        this.persistence.delete(castMemberFounded);
    }
}

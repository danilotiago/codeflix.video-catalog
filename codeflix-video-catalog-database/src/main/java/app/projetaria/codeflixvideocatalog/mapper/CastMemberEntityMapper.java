package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.domain.CastMember;
import app.projetaria.codeflixvideocatalog.entity.CastMemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CastMemberEntityMapper {

    CastMemberEntityMapper INSTANCE = Mappers.getMapper(CastMemberEntityMapper.class);

    CastMember from(CastMemberEntity object);

    CastMemberEntity from(CastMember object);

    List<CastMember> from(List<CastMemberEntity> objects);
}

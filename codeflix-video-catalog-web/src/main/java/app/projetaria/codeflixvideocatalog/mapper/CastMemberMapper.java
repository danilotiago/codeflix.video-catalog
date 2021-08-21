package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.domain.CastMember;
import app.projetaria.codeflixvideocatalog.dto.CastMemberRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.CastMemberResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CastMemberMapper {

    CastMemberMapper INSTANCE = Mappers.getMapper(CastMemberMapper.class);

    CastMember from(CastMemberRequestDTO data);

    CastMemberResponseDTO from(CastMember data);

    List<CastMemberResponseDTO> from(List<CastMember> data);
}

package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.domain.CastMember;
import app.projetaria.codeflixvideocatalog.domain.CastMember.CastMemberBuilder;
import app.projetaria.codeflixvideocatalog.dto.CastMemberRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.CastMemberResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-21T00:11:42-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class CastMemberMapperImpl implements CastMemberMapper {

    @Override
    public CastMember from(CastMemberRequestDTO data) {
        if ( data == null ) {
            return null;
        }

        CastMemberBuilder castMember = CastMember.builder();

        castMember.name( data.getName() );
        castMember.position( data.getPosition() );
        castMember.isActive( data.getIsActive() );

        return castMember.build();
    }

    @Override
    public CastMemberResponseDTO from(CastMember data) {
        if ( data == null ) {
            return null;
        }

        CastMemberResponseDTO castMemberResponseDTO = new CastMemberResponseDTO();

        castMemberResponseDTO.setCode( data.getCode() );
        castMemberResponseDTO.setName( data.getName() );
        castMemberResponseDTO.setPosition( data.getPosition() );
        castMemberResponseDTO.setIsActive( data.getIsActive() );
        castMemberResponseDTO.setCreatedAt( data.getCreatedAt() );
        castMemberResponseDTO.setUpdatedAt( data.getUpdatedAt() );
        castMemberResponseDTO.setDeletedAt( data.getDeletedAt() );

        return castMemberResponseDTO;
    }

    @Override
    public List<CastMemberResponseDTO> from(List<CastMember> data) {
        if ( data == null ) {
            return null;
        }

        List<CastMemberResponseDTO> list = new ArrayList<CastMemberResponseDTO>( data.size() );
        for ( CastMember castMember : data ) {
            list.add( from( castMember ) );
        }

        return list;
    }
}

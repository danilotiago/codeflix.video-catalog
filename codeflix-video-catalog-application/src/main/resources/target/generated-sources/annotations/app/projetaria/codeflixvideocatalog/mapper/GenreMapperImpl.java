package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.domain.Genre;
import app.projetaria.codeflixvideocatalog.domain.Genre.GenreBuilder;
import app.projetaria.codeflixvideocatalog.dto.GenreRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.GenreResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-28T23:42:21-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class GenreMapperImpl implements GenreMapper {

    @Override
    public Genre from(GenreRequestDTO data) {
        if ( data == null ) {
            return null;
        }

        GenreBuilder genre = Genre.builder();

        genre.name( data.getName() );
        genre.isActive( data.getIsActive() );

        return genre.build();
    }

    @Override
    public GenreResponseDTO from(Genre data) {
        if ( data == null ) {
            return null;
        }

        GenreResponseDTO genreResponseDTO = new GenreResponseDTO();

        genreResponseDTO.setCode( data.getCode() );
        genreResponseDTO.setName( data.getName() );
        genreResponseDTO.setIsActive( data.getIsActive() );
        genreResponseDTO.setCreatedAt( data.getCreatedAt() );
        genreResponseDTO.setUpdatedAt( data.getUpdatedAt() );
        genreResponseDTO.setDeletedAt( data.getDeletedAt() );

        return genreResponseDTO;
    }

    @Override
    public List<GenreResponseDTO> from(List<Genre> data) {
        if ( data == null ) {
            return null;
        }

        List<GenreResponseDTO> list = new ArrayList<GenreResponseDTO>( data.size() );
        for ( Genre genre : data ) {
            list.add( from( genre ) );
        }

        return list;
    }
}

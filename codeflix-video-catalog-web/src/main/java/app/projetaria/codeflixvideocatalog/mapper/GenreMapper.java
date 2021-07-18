package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.domain.Genre;
import app.projetaria.codeflixvideocatalog.dto.GenreRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.GenreResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    Genre from(GenreRequestDTO data);

    GenreResponseDTO from(Genre data);

    List<GenreResponseDTO> from(List<Genre> data);
}

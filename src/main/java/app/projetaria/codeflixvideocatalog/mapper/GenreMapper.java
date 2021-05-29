package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.dto.GenreRequestDTO;
import app.projetaria.codeflixvideocatalog.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    Genre from(GenreRequestDTO data);
}

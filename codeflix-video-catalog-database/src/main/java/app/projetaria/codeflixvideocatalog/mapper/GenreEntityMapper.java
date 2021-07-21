package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.domain.Genre;
import app.projetaria.codeflixvideocatalog.entity.CategoryEntity;
import app.projetaria.codeflixvideocatalog.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GenreEntityMapper {

    GenreEntityMapper INSTANCE = Mappers.getMapper(GenreEntityMapper.class);

    Genre from(GenreEntity object);

    GenreEntity from(Genre object);

    List<Genre> from(List<GenreEntity> objects);
}

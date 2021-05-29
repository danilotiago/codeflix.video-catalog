package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.dto.CategoryRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.CategoryResponseDTO;
import app.projetaria.codeflixvideocatalog.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category from(CategoryRequestDTO data);

    CategoryResponseDTO from(Category data);
}

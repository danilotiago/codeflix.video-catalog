package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.dto.CategoryRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.CategoryResponseDTO;
import app.projetaria.codeflixvideocatalog.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category from(CategoryRequestDTO data);

    CategoryResponseDTO from(Category data);

    List<CategoryResponseDTO> from(List<Category> data);
}

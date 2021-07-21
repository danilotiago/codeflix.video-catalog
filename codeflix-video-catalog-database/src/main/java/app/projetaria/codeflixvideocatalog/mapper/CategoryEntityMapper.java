package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryEntityMapper {

    CategoryEntityMapper INSTANCE = Mappers.getMapper(CategoryEntityMapper.class);

    Category from(CategoryEntity object);

    CategoryEntity from(Category object);

    List<Category> from(List<CategoryEntity> objects);
}

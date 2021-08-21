package app.projetaria.codeflixvideocatalog.mapper;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.domain.Category.CategoryBuilder;
import app.projetaria.codeflixvideocatalog.dto.CategoryRequestDTO;
import app.projetaria.codeflixvideocatalog.dto.CategoryResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-20T22:43:05-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category from(CategoryRequestDTO data) {
        if ( data == null ) {
            return null;
        }

        CategoryBuilder category = Category.builder();

        category.name( data.getName() );
        category.description( data.getDescription() );
        category.isActive( data.getIsActive() );

        return category.build();
    }

    @Override
    public CategoryResponseDTO from(Category data) {
        if ( data == null ) {
            return null;
        }

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();

        categoryResponseDTO.setCode( data.getCode() );
        categoryResponseDTO.setName( data.getName() );
        categoryResponseDTO.setDescription( data.getDescription() );
        categoryResponseDTO.setIsActive( data.getIsActive() );
        categoryResponseDTO.setCreatedAt( data.getCreatedAt() );
        categoryResponseDTO.setUpdatedAt( data.getUpdatedAt() );
        categoryResponseDTO.setDeletedAt( data.getDeletedAt() );

        return categoryResponseDTO;
    }

    @Override
    public List<CategoryResponseDTO> from(List<Category> data) {
        if ( data == null ) {
            return null;
        }

        List<CategoryResponseDTO> list = new ArrayList<CategoryResponseDTO>( data.size() );
        for ( Category category : data ) {
            list.add( from( category ) );
        }

        return list;
    }
}

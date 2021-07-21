package app.projetaria.codeflixvideocatalog.persistence;

import app.projetaria.codeflixvideocatalog.domain.Category;
import app.projetaria.codeflixvideocatalog.entity.CategoryEntity;
import app.projetaria.codeflixvideocatalog.mapper.CategoryEntityMapper;
import app.projetaria.codeflixvideocatalog.ports.persistence.CategoryPersistence;
import app.projetaria.codeflixvideocatalog.repository.CategoryRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CategoryPersistenceAdapterImpl implements CategoryPersistence {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category get(UUID code) {
        Optional<CategoryEntity> result = this.repository.findById(code);
        if (result.isPresent()) {
            return CategoryEntityMapper.INSTANCE.from(result.get());
        }
        return null;
    }

    @Override
    public List<Category> list() {
        List<CategoryEntity> categories = this.repository.findByDeletedAtNull();
        return CategoryEntityMapper.INSTANCE.from(categories);
    }

    @Override
    public List<Category> listOnlyTrashed() {
        List<CategoryEntity> categories =  this.repository.findByDeletedAtNotNull();

        return CategoryEntityMapper.INSTANCE.from(categories);
    }

    @Override
    public List<Category> listWithTrashed() {
        List<Category> categories = this.list();
        categories.addAll(this.listOnlyTrashed());

        return categories;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = CategoryEntityMapper.INSTANCE.from(category);
        categoryEntity = this.repository.save(categoryEntity);
        return CategoryEntityMapper.INSTANCE.from(categoryEntity);
    }

    @Override
    public void delete(Category category) {
        this.repository.deleteById(category.getCode());
    }

    @Override
    public void active(Category category) {
        this.save(category);
    }

    @Override
    public void inactive(Category category) {
        this.save(category);
    }
}

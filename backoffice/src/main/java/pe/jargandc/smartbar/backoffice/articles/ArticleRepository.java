package pe.jargandc.smartbar.backoffice.articles;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.jargandc.smartbar.backoffice.category.CategoryEntity;

import java.util.List;

@ApplicationScoped
public class ArticleRepository implements PanacheRepository<ArticleEntity> {
    public List<ArticleEntity> listByCategory(CategoryEntity category){
        return list("category", category);
    }
}

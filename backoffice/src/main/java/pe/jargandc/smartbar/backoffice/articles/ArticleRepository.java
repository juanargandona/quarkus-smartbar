package pe.jargandc.smartbar.backoffice.articles;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import pe.jargandc.smartbar.backoffice.category.CategoryEntity;

import java.util.List;

@ApplicationScoped
public class ArticleRepository implements PanacheRepository<ArticleEntity> {
//    public List<ArticleEntity> listByCategory(CategoryEntity category){
//        return list("category", category);
//    }

//    public List<ArticleEntity> listByCategory(CategoryEntity category){
//        //return list("category", category);
//        return find("category", Sort.by("price", Sort.Direction.Descending), category)
//                .page(Page.ofSize(3))
//                .list();
//    }

    public List<ArticleEntity> listByCategory(CategoryEntity category){
        //return list("category", category);
        return find("#Article.byCategory", category)
                .page(Page.ofSize(3))
                .list();
    }

}

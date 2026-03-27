package org.jargc.articles;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.jargc.categories.Category;
import org.jargc.tables.Table;

import java.util.List;

@ApplicationScoped
public class ArticlesRepository implements PanacheRepository<Article> {

    public List<Article> listByCategory(Category category){
        /*return find("category",
                Sort.by("price", Sort.Direction.Ascending),
                category)
                .page(Page.ofSize(3))
                .list();*/

        return find("#Article.byCategory", category)
                .page(Page.ofSize(3))
                .list();
    }
}

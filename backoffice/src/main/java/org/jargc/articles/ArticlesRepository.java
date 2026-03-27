package org.jargc.articles;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.jargc.categories.Category;
import org.jargc.tables.Table;

import java.util.List;

@ApplicationScoped
public class ArticlesRepository implements PanacheRepository<Article> {

    public List<Article> listByCategory(Category category){
        return list("category", category);
    }
}

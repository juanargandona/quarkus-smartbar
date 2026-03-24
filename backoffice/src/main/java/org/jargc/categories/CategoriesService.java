package org.jargc.categories;

import jakarta.enterprise.context.ApplicationScoped;
import org.jargc.smartbar.backoffice.api.model.Article;
import org.jargc.smartbar.backoffice.api.model.Category;

@ApplicationScoped
public class CategoriesService {
    private final Category category = new Category().name("drinks");

    public Category getCategory(){
        return category;
    }
}

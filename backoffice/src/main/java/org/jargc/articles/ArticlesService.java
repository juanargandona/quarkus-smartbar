package org.jargc.articles;

import jakarta.enterprise.context.ApplicationScoped;
import org.jargc.smartbar.backoffice.api.model.Article;

@ApplicationScoped
public class ArticlesService {
    private final Article article = new Article().name("cola");

    public Article getArticle(){
        return article;
    }
}

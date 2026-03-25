package org.jargc.articles;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import org.jargc.CrudService;
import org.jargc.smartbar.backoffice.api.model.ApiArticle;

@ApplicationScoped
public class ArticlesService extends CrudService<Article> {
    public ArticlesService() {
        super(null);
    }

    protected ArticlesService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }
}

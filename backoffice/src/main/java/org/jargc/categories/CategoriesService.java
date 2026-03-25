package org.jargc.categories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import org.jargc.CrudService;
import org.jargc.smartbar.backoffice.api.model.ApiCategory;

@ApplicationScoped
public class CategoriesService extends CrudService<Category> {
    private final ApiCategory category = new ApiCategory().name("drinks");

    public CategoriesService() {
        super(null);
    }

    protected CategoriesService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}

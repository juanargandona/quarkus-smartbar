package org.jargc.categories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriesRepository implements PanacheRepository<Category> {

}

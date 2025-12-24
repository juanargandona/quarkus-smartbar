package pe.jargandc.smartbar.backoffice.articles;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface ArticleController extends PanacheEntityResource<ArticleEntity, Long> {

}

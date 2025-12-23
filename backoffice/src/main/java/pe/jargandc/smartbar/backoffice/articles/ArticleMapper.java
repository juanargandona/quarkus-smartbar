package pe.jargandc.smartbar.backoffice.articles;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import pe.jargandc.backoffice.api.model.Article;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ArticleMapper {
    @Mapping(target = "id", ignore = true)
    void mapToEntity(Article table, @MappingTarget ArticleEntity entity);

    Article mapToArticle(ArticleEntity entity);
}

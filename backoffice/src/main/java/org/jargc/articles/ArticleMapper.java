package org.jargc.articles;

import org.jargc.smartbar.backoffice.api.model.ApiArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ArticleMapper {

    @Mapping(target="id", ignore=true)
    void mapToArticle(ApiArticle apiArticle, @MappingTarget Article article);

    ApiArticle mapToApiArticle(Article article);
}

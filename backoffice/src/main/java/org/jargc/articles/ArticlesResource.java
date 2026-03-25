package org.jargc.articles;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jargc.categories.CategoriesService;
import org.jargc.categories.Category;
import org.jargc.smartbar.backoffice.api.ArticlesApi;
import org.jargc.smartbar.backoffice.api.model.ApiArticle;

import java.net.URI;
import java.util.Optional;

public class ArticlesResource implements ArticlesApi {

    private final CategoriesService categoriesService;
    private final ArticlesService articlesService;

    @Inject
    public ArticlesResource(CategoriesService categoriesService, ArticlesService articlesService) {
        this.categoriesService = categoriesService;
        this.articlesService = articlesService;
    }


    @Override
    public Response createArticle(Long xCategoryId, ApiArticle apiArticle) {
        final Optional<Category> category = categoriesService.getById(xCategoryId);
        if(category.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = new Article();
        article.setName(apiArticle.getName());
        article.setDescription(apiArticle.getDescription());
        article.setPrice(apiArticle.getPrice());
        article.setPicture(apiArticle.getPicture());

        final Article persistedArticle = articlesService.persist(article);
        return Response.created(URI.create("/articles/"+persistedArticle.getId())).build();
    }



    @Override
    public Response deleteArticle(Long articleId) {
        return null;
    }

    @Override
    public Response getArticle(Long articleId) {
        return null;
    }

    @Override
    public Response getArticles() {
        return null;
    }

    @Override
    public Response updateArticle(Long articleId, ApiArticle apiArticle) {
        return null;
    }
}

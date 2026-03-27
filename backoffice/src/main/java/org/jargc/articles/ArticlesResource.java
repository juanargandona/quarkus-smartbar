package org.jargc.articles;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.jargc.categories.CategoriesService;
import org.jargc.categories.Category;
import org.jargc.smartbar.backoffice.api.ArticlesApi;
import org.jargc.smartbar.backoffice.api.model.ApiArticle;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class ArticlesResource implements ArticlesApi {

    private final ArticleMapper mapper;
    private final ArticlesRepository articlesRepository;
    private final CategoriesService categoriesService;

    @Inject
    public ArticlesResource(ArticleMapper mapper, ArticlesRepository articlesRepository, CategoriesService categoriesService) {
        this.mapper = mapper;
        this.articlesRepository = articlesRepository;
        this.categoriesService = categoriesService;
    }





    //@Override
    public void createArticle2(Long xCategoryId, ApiArticle apiArticle) {
        /*final Optional<Category> category = categoriesService.getById(xCategoryId);
        if(category.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = new Article();
        mapper.mapToArticle(apiArticle, article);
        article.setCategory(category.get());
        articlesRepository.persist(article);


        return Response.created(URI.create("/articles/"+article.getId())).build();
        */

    }


    @Override
    public Response createArticle(Long xCategoryId, ApiArticle apiArticle) {
        return null;
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

    @GET
    @Path("/categories/{categoryId}")
    @Produces({"application/json"})
    public Response listByCategory(@PathParam("categoryId") Long categoryId){
        final Optional<Category> category = categoriesService.getById(categoryId);
        if(category.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<Article> articles = articlesRepository.listByCategory(category.get());
        return Response.ok(articles.stream().map(mapper::mapToApiArticle)).build();
    }
}

package org.jargc.articles;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.jargc.categories.CategoriesRepository;
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
    private final CategoriesRepository categoriesRepository;

    @Inject
    public ArticlesResource(ArticleMapper mapper, ArticlesRepository articlesRepository, CategoriesService categoriesService, CategoriesRepository categoriesRepository) {
        this.mapper = mapper;
        this.articlesRepository = articlesRepository;
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public Response createArticle(Long xCategoryId, ApiArticle apiArticle) {
        final Optional<Category> category = categoriesRepository.findByIdOptional(xCategoryId);
        if(category.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = new Article();
        mapper.mapToArticle(apiArticle, article);
        article.setCategory(category.get());
        articlesRepository.persist(article);

        return Response.created(URI.create("/articles/"+article.getId())).build();
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
        List<Article> articles = articlesRepository.listAll();
        return Response.ok(articles.stream().map(mapper::mapToApiArticle)).build();
    }

    @Override
    public Response updateArticle(Long articleId, ApiArticle apiArticle) {
        return null;
    }

    @GET
    @Path("/category/{categoryId}")
    @Produces({"application/json"})
    public Response listByCategory(@PathParam("categoryId") Long categoryId){
        final Optional<Category> category = categoriesRepository.findByIdOptional(categoryId);
        if(category.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<Article> articles = articlesRepository.listByCategory(category.get());
        return Response.ok(articles.stream().map(mapper::mapToApiArticle)).build();
    }
}

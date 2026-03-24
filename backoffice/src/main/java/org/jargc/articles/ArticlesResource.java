package org.jargc.articles;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jargc.smartbar.backoffice.api.ArticlesApi;
import org.jargc.smartbar.backoffice.api.model.Article;

import java.util.List;

public class ArticlesResource implements ArticlesApi {

    private final Article article = new Article().name("Chardonnay");

    private final ArticlesService articlesService;

    @Inject
    public ArticlesResource(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }


    @Override
    public Response createArticle(Article article) {
        return null;
    }

    @Override
    public Response deleteArticle(String articleId) {
        return null;
    }

    @Override
    public Response getArticle(String articleId) {
        return Response.ok(articlesService.getArticle()).build();
    }

    @Override
    public Response getArticles() {
        return Response.ok(List.of(articlesService.getArticle())).build();
    }

    @Override
    public Response updateArticle(String articleId, Article article) {
        return null;
    }
}

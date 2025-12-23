package pe.jargandc.smartbar.backoffice.articles;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import pe.jargandc.backoffice.api.ArticlesApi;
import pe.jargandc.backoffice.api.model.Article;
import pe.jargandc.smartbar.backoffice.category.CategoryEntity;
import pe.jargandc.smartbar.backoffice.category.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class ArticleController implements ArticlesApi {

    private final ArticleMapper mapper;
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    public ArticleController(ArticleMapper mapper, ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.mapper = mapper;
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Response createArticle(Long xCategoryId, Article article) {
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
    public Response updateArticle(Long articleId, Article article) {
        return null;
    }

    @GET
    @Path("/category/{categoryId}")
    @Produces({"application/json"})
    public Response getByCategory(@PathParam("categoryId") Long categoryId)  {
        final Optional<CategoryEntity> category = categoryRepository.findByIdOptional(categoryId);
        if(category.isEmpty()){
            Response.status(Response.Status.NOT_FOUND).build();
        }
        final List<Article> art= articleRepository.listByCategory(category.get())
                .stream().map(mapper::mapToArticle).toList();
        return Response.ok(art).build();

    }
}

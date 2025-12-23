package pe.jargandc.smartbar.backoffice.category;

import jakarta.ws.rs.core.Response;
import pe.jargandc.backoffice.api.CategoriesApi;
import pe.jargandc.backoffice.api.CategoriesApi;
import pe.jargandc.backoffice.api.model.Category;

public class CategoryController implements CategoriesApi {

    private final CategoryMapper mapper;
    private final CategoryRepository repository;

    public CategoryController(CategoryMapper mapper, CategoryRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Response createCategory(Category category) {
        return null;
    }

    @Override
    public Response deleteCategory(Long categoryId) {
        return null;
    }

    @Override
    public Response getCategories() {
        return Response.ok(repository.listAll()
                .stream().map(mapper::mapToCategory)
        ).build();
    }

    @Override
    public Response getCategory(Long categoryId) {
        return null;
    }

    @Override
    public Response updateCategory(Long categoryId, Category category) {
        return null;
    }
}

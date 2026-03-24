package org.jargc.categories;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jargc.smartbar.backoffice.api.CategoriesApi;
import org.jargc.smartbar.backoffice.api.model.Category;

import java.util.List;

public class CategoriesResource implements CategoriesApi {

    //private final Category category = new Category().name("drinks");
    @Inject
    private final CategoriesService categoriesService;

    public CategoriesResource(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @Override
    public Response createCategory(Category category) {
        return null;
    }

    @Override
    public Response deleteCategory(String categoryId) {
        return null;
    }

    @Override
    public Response getCategories() {
        return Response.ok(List.of(categoriesService.getCategory())).build();
    }

    @Override
    public Response getCategory(String categoryId) {
        return null;
    }

    @Override
    public Response updateCategory(String categoryId, Category category) {
        return null;
    }
}

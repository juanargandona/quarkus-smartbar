package org.jargc.categories;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jargc.smartbar.backoffice.api.CategoriesApi;
import org.jargc.smartbar.backoffice.api.model.ApiCategory;

import java.util.List;

public class CategoriesResource implements CategoriesApi {

    private final CategoriesService categoriesService;

    @Inject
    public CategoriesResource(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @Override
    public Response createCategory(ApiCategory apiCategory) {
        return null;
    }

    @Override
    public Response deleteCategory(Long categoryId) {
        return null;
    }

    @Override
    public Response getCategories() {
        return Response.ok(categoriesService.getAll()).build();
    }

    @Override
    public Response getCategory(Long categoryId) {
        return null;
    }

    @Override
    public Response updateCategory(Long categoryId, ApiCategory apiCategory) {
        return null;
    }
}

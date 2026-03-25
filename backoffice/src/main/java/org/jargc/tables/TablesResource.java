package org.jargc.tables;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jargc.categories.CategoriesService;
import org.jargc.smartbar.backoffice.api.TablesApi;
import org.jargc.smartbar.backoffice.api.model.ApiTable;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class TablesResource implements TablesApi {

    //private final Category category = new Category().name("drinks");

    private final TablesService tablesService;
    private final TableMapper mapper;

    @Inject
    public TablesResource(TablesService tablesService, TableMapper mapper) {
        this.tablesService = tablesService;
        this.mapper = mapper;
    }


    @Override
    public Response createTable(ApiTable apiTable) {
        final Table table = new Table();
        mapper.mapToTable(apiTable, table);
        Table persistedTable =tablesService.persist(table);
        return Response.created(URI.create("/tables/"+persistedTable.getId())).build();
    }

    @Override
    public Response deleteTable(Long tableId) {
        return null;
    }

    @Override
    public Response getTable(Long tableId) {
        return null;
    }

    @Override
    public Response getTables() {
        List<Table> tables = tablesService.getAll();
        return Response.ok(tables.stream().map(mapper::mapToApiTable).toList()).build();
    }

    @Override
    public Response updateTable(Long tableId, ApiTable apiTable) {
        Optional<Table> persistedTable = tablesService.getById(tableId);
        if(persistedTable.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Table table = persistedTable.get();
        mapper.mapToTable(apiTable, table);
        tablesService.update(table);
        return Response.ok().build();
    }
}

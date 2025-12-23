package pe.jargandc.smartbar.backoffice.tables;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import pe.jargandc.backoffice.api.TablesApi;
import pe.jargandc.backoffice.api.model.Table;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Transactional
public class TableController implements TablesApi {

    private final TableMapper mapper;
    private final TableRepository repository;

    @Inject
    public TableController(TableMapper mapper, TableRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    @Transactional
    public Response createTable(Table table) {
        TableEntity entity = new TableEntity();
        mapper.mapToEntity(table,entity);
        repository.persist(entity);
        return Response.created(URI.create("./tables/"+entity.id)).build();
    }

    @Override
    public Response deleteTable(Long tableId) {
        Optional<TableEntity> optional = repository.findByIdOptional(tableId);
        if(optional.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        repository.delete(optional.get());
        return Response.ok().build();
    }

    @Override
    public Response getTable(Long tableId) {
        Optional<TableEntity> optional = repository.findByIdOptional(tableId);
        if(optional.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(mapper.mapToTable(optional.get())).build();
    }

    @Override
    public Response getTables() {
        final List<TableEntity> entityList = repository.listAll();
        return Response.ok(entityList.stream().map(mapper::mapToTable)).build();
    }

    @Override
    public Response updateTable(Long tableId, Table table) {
        Optional<TableEntity> optional = repository.findByIdOptional(tableId);
        if(optional.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        mapper.mapToEntity(table, optional.get());
        return Response.ok().build();
    }
}

package pe.jargandc.smartbar.backoffice.tables;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
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

    @Inject
    public TableController(TableMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Response createTable(Table table) {
        TableEntity entity = new TableEntity();
        mapper.mapToEntity(table,entity);
        entity.persist();
        return Response.created(URI.create("./tables/"+entity.id)).build();
    }

    @Override
    public Response deleteTable(Long tableId) {
        Optional<TableEntity> optional = TableEntity.findByIdOptional(tableId);
        if(optional.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        optional.get().delete();
        return Response.ok().build();
    }

    @Override
    public Response getTable(Long tableId) {
        Optional<TableEntity> optional = TableEntity.findByIdOptional(tableId);
        if(optional.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(mapper.mapToTable(optional.get())).build();
    }

    @Override
    public Response getTables() {
        final List<TableEntity> entityList = TableEntity.listAll();
        return Response.ok(entityList.stream().map(mapper::mapToTable)).build();
    }

    @Override
    public Response updateTable(Long tableId, Table table) {
        Optional<TableEntity> optional = TableEntity.findByIdOptional(tableId);
        if(optional.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        mapper.mapToEntity(table, optional.get());
        return Response.ok().build();
    }
}

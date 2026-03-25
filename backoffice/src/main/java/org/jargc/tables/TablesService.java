package org.jargc.tables;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.jargc.CrudService;

@ApplicationScoped
public class TablesService extends CrudService<Table> {

    public TablesService() {
        super(null);
    }

    @Inject
    protected TablesService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Table> getEntityClass() {
        return Table.class;
    }
}

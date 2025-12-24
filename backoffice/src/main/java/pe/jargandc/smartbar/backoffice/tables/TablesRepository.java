package pe.jargandc.smartbar.backoffice.tables;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TablesRepository implements PanacheRepositoryBase<TableEntity, Long> {
}

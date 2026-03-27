package org.jargc.tables;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TablesRepository implements PanacheRepository<Table> {
}

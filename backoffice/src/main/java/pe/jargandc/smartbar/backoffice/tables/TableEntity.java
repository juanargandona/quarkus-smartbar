package pe.jargandc.smartbar.backoffice.tables;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tables", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class TableEntity extends PanacheEntity {
    @NotNull
    public String name;

    @NotNull
    public Integer seatCount;

    @NotNull
    public Boolean active;
}

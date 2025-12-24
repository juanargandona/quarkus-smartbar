package pe.jargandc.smartbar.backoffice.tables;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import pe.jargandc.smartbar.backoffice.BaseEntity;

@Entity
@Table(name = "tables", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class TableEntity extends BaseEntity {
    @NotNull
    public String name;

    @NotNull
    public Integer seatCount;

    @NotNull
    public Boolean active;
}

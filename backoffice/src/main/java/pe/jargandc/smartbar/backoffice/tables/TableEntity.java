package pe.jargandc.smartbar.backoffice.tables;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import pe.jargandc.smartbar.backoffice.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "tables", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class TableEntity extends BaseEntity {
    @NotNull
    private String name;

    @NotNull
    private Integer seatCount;

    @NotNull
    private Boolean active;
}

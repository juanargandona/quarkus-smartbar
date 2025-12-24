package pe.jargandc.smartbar.backoffice.category;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import pe.jargandc.smartbar.backoffice.BaseEntity;


@Entity
@Table(name = "categories", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class CategoryEntity extends BaseEntity {
    @NotNull
    public String name;

    @NotNull
    public String description;
}

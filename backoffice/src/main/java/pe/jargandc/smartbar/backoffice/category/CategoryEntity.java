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
    private String name;

    @NotNull
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

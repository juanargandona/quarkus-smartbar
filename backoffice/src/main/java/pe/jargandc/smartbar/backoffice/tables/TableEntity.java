package pe.jargandc.smartbar.backoffice.tables;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import pe.jargandc.smartbar.backoffice.BaseEntity;

@Entity
@Table(name = "tables", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class TableEntity extends BaseEntity {
    @NotNull
    private String name;

    @NotNull
    private Integer seatCount;

    @NotNull
    private Boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

package org.jargc.categories;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.jargc.BaseEntity;

import java.math.BigDecimal;

@Entity
@jakarta.persistence.Table(name = "categories")
public class Category extends BaseEntity {
    private String name;
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

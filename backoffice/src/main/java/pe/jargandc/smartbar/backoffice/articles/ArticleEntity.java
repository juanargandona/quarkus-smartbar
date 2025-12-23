package pe.jargandc.smartbar.backoffice.articles;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import pe.jargandc.smartbar.backoffice.category.CategoryEntity;

import java.math.BigDecimal;


@Entity
@Table(name = "articles", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class ArticleEntity extends PanacheEntity {
    @NotNull
    public String name;

    @NotNull
    public BigDecimal price;

    @NotNull
    public String description;

    @NotNull
    public String picture;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}

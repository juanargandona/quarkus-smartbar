package org.jargc.articles;

import jakarta.persistence.*;
import org.jargc.BaseEntity;
import org.jargc.categories.Category;

import java.math.BigDecimal;

@Entity
@jakarta.persistence.Table(name = "articles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name", "category_id"
        })
})
@NamedQueries({
        @NamedQuery(name = "Article.byCategory", query = "from Article where category =?1" +
                "order by price asc")
})
public class Article extends BaseEntity {
    private String name;
    private BigDecimal price;
    private String description;
    private String picture;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;


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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

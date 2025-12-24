package pe.jargandc.smartbar.backoffice.articles;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import pe.jargandc.smartbar.backoffice.category.CategoryEntity;

import java.math.BigDecimal;


@Entity
@Table(name = "articles", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@NamedQueries(
        {
                @NamedQuery(name = "Article.byCategory", query = "from ArticleEntity where category = ?1 order by price desc")
        }
)
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
    public CategoryEntity category;


}

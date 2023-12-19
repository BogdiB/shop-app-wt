package shop.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "productCategories")
@Data @NoArgsConstructor @AllArgsConstructor
public class ProductCategoryEntity extends BaseEntity
{
    @OneToMany(mappedBy = "category")
    private Set<ProductEntity> product;
    private String name;
    private String description;

    public ProductCategoryEntity(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
}

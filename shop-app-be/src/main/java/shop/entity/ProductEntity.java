package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
@Data @NoArgsConstructor @AllArgsConstructor
public class ProductEntity extends BaseEntity implements Serializable
{
    @OneToMany(mappedBy = "stockID.product")
    private Set<StockEntity> stock;
    @OneToMany(mappedBy = "orderDetailId.product")
    private Set<OrderDetailEntity> orderDetailEntities;
    private String name;
    private String description;
    private BigDecimal price;
    private double weight;
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductCategoryEntity category;
    private String imageURL;

    public ProductEntity(String name, String description, BigDecimal price, double weight, ProductCategoryEntity category, String imageURL)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.category = category;
        this.imageURL = imageURL;
    }
}

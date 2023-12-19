package shop.entity.ids;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.OrderEntity;
import shop.entity.ProductEntity;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailID implements Serializable
{
    @ManyToOne(cascade = CascadeType.ALL)
    private OrderEntity orders;
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductEntity product;
}

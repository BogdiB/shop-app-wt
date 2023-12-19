// Order Detail ID
package ro.msg.learning.shop.entity.ids;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import ro.msg.learning.shop.entity.OrderEntity;
import ro.msg.learning.shop.entity.ProductEntity;

@Data
@Embeddable
@AllArgsConstructor
public class OrderDetailID
{
    @ManyToOne(cascade = CascadeType.ALL)
    private OrderEntity orders;
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductEntity product;
}

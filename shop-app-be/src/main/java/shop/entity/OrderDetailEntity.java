package shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.entity.ids.OrderDetailID;

@Entity
@Table(name = "orderDetails")
@Data @NoArgsConstructor @AllArgsConstructor
public class OrderDetailEntity
{
    @EmbeddedId
    private OrderDetailID orderDetailId;
    @ManyToOne(cascade = CascadeType.ALL)
    private LocationEntity shippedFrom;
    private int quantity;
}

package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity
{
    @OneToMany(mappedBy = "orderDetailId.orders", cascade = CascadeType.PERSIST)
    private List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerEntity customer;
    private LocalDateTime createdAt;
    // address
    private String country;
    private String city;
    private String county;
    private String street;

    public OrderEntity(LocalDateTime createdAt, String country, String city, String county, String street)
    {
        this.createdAt = createdAt;
        this.country = country;
        this.city = city;
        this.county = county;
        this.street = street;
    }

    public void addOrderDetail(final OrderDetailEntity orderDetail)
    {
        orderDetailEntities.add(orderDetail);
        orderDetail.getOrderDetailId().setOrders(this);
    }
}

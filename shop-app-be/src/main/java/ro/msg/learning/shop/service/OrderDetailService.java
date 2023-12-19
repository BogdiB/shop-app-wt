package ro.msg.learning.shop.service;

import ro.msg.learning.shop.entity.OrderDetailEntity;
import ro.msg.learning.shop.entity.ids.OrderDetailID;

import java.util.Collection;
import java.util.UUID;

public interface OrderDetailService
{
    void createOrderDetail(OrderDetailEntity orderDetail);
    OrderDetailEntity getOrderDetail(OrderDetailID id);
    Collection<OrderDetailEntity> getOrderDetail();
    void updateOrderDetail(OrderDetailEntity orderDetail);
    void deleteOrderDetail(OrderDetailID id);
}

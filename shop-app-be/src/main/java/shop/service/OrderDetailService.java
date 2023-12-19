package shop.service;

import shop.entity.OrderDetailEntity;
import shop.entity.ids.OrderDetailID;
import java.util.Collection;

public interface OrderDetailService
{
    void createOrderDetail(OrderDetailEntity orderDetail);
    OrderDetailEntity getOrderDetail(OrderDetailID id);
    Collection<OrderDetailEntity> getOrderDetail();
    void updateOrderDetail(OrderDetailEntity orderDetail);
    void deleteOrderDetail(OrderDetailID id);
}

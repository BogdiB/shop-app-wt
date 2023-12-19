package ro.msg.learning.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.OrderDetailEntity;
import ro.msg.learning.shop.entity.ids.OrderDetailID;
import ro.msg.learning.shop.repository.OrderDetailRepository;
import ro.msg.learning.shop.service.OrderDetailService;

import java.util.Collection;
import java.util.UUID;

@Service
public class OrderDetailServiceImpl implements OrderDetailService
{
    @Autowired
    private OrderDetailRepository orderDetailRepo;

    @Override
    public void createOrderDetail(OrderDetailEntity orderDetail)
    {
        orderDetailRepo.save(orderDetail);
    }

    @Override
    public OrderDetailEntity getOrderDetail(OrderDetailID id)
    {
        return orderDetailRepo.getReferenceById(id);
    }

    @Override
    public Collection<OrderDetailEntity> getOrderDetail()
    {
        return orderDetailRepo.findAll();
    }

    @Override
    public void updateOrderDetail(OrderDetailEntity orderDetail)
    {
        orderDetailRepo.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(OrderDetailID id)
    {
        orderDetailRepo.deleteById(id);
    }
}

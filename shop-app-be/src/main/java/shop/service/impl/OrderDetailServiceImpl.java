package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.OrderDetailEntity;
import shop.entity.ids.OrderDetailID;
import shop.repository.OrderDetailRepository;
import shop.service.OrderDetailService;
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

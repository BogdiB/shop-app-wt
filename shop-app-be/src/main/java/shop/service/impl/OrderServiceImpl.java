package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.*;
import shop.entity.ids.OrderDetailID;
import shop.repository.OrderRepository;
import shop.service.OrderService;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private LocationServiceImpl locationService;
    @Autowired
    private ProductServiceImpl productService;

    public boolean checkLocation(OrderEntity order, LocationEntity loc)
    {
        // checking if the location has the things in stock
        for (OrderDetailEntity orderDetailEntity : order.getOrderDetailEntities())
            for (StockEntity st : loc.getStock())
                if (!st.getStockID().getProduct().equals(orderDetailEntity.getOrderDetailId().getProduct())
                        || st.getQuantity() < orderDetailEntity.getQuantity())
                    return false;
        // updating the quantity in the stock
        for (OrderDetailEntity orderDetailEntity : order.getOrderDetailEntities())
            for (StockEntity st : loc.getStock())
                if (st.getStockID().getProduct().equals(orderDetailEntity.getOrderDetailId().getProduct()))
                    st.setQuantity(st.getQuantity() - orderDetailEntity.getQuantity());
        return true;
    }

    public boolean forLocations(OrderEntity order)
    {
        for (LocationEntity loc : locationService.getLocation())
            if (checkLocation(order, loc))
                return true;
        return false;
    }

    @Override
    public OrderEntity createOrder(OrderEntity order, Map<UUID, Integer> productToQuantityMap)
    {
        //for product: productQuantity
            // find product
            // new OrderDetail (orde
        if (forLocations(order))
        {
            orderRepo.save(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean checkSingleLocation(LocationEntity location, OrderEntity order, Map<UUID, Integer> productToQuantityMap)
    {
        boolean checker;
        for (UUID id : productToQuantityMap.keySet())
        {
            checker = false;
            for (StockEntity stock : location.getStock())
                if (stock.getStockID().getProduct().getId().equals(id) && stock.getQuantity() >= productToQuantityMap.get(id))
                {
                    checker = true;
                    break;
                }
            if (!checker)
                return false;
        }
        return true;
    }

    @Override
    public LocationEntity findSingleLocation(OrderEntity order, Map<UUID, Integer> productToQuantityMap)
    {
        for (LocationEntity location : locationService.getLocation())
            if (checkSingleLocation(location, order, productToQuantityMap))
                return location;
        return null;
    }

    @Override
    public OrderEntity createOrder(OrderEntity order, Map<UUID, Integer> productToQuantityMap, LocationEntity location)
    {
        if (location != null)
        {
            OrderEntity newOrder = new OrderEntity(order.getCreatedAt(), location.getCountry(), location.getCity(), location.getCounty(), location.getStreet());
            List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();
            OrderDetailEntity orderDetail = new OrderDetailEntity();
            for (UUID id : productToQuantityMap.keySet())
            {
                orderDetail.setOrderDetailId(new OrderDetailID(newOrder, productService.getProduct(id)));
                orderDetail.setShippedFrom(location);
                orderDetail.setQuantity(productToQuantityMap.get(id));

                orderDetailEntities.add(orderDetail);
            }
            newOrder.setOrderDetailEntities(orderDetailEntities);
            newOrder.setCustomer(null);

            updateStockAtLocation(location, productToQuantityMap, order);
            return orderRepo.save(newOrder);
        }
        return null;
    }

    public void updateStockAtLocation(LocationEntity location, Map<UUID, Integer> productToQuantityMap, OrderEntity order)
    {
        for (UUID id : productToQuantityMap.keySet())
            for (StockEntity stock : location.getStock())
                if (stock.getStockID().getProduct().getId().equals(id) && stock.getQuantity() >= productToQuantityMap.get(id))
                {
                    stock.setQuantity(stock.getQuantity() - productToQuantityMap.get(id));
                    break;
                }
    }

    @Override
    public OrderEntity getOrder(UUID id)
    {
        return orderRepo.getReferenceById(id);
    }

    @Override
    public Collection<OrderEntity> getOrders()
    {
        return orderRepo.findAll();
    }

    @Override
    public void updateOrder(OrderEntity order)
    {
        orderRepo.save(order);
    }

    @Override
    public void deleteOrder(UUID id)
    {
        orderRepo.deleteById(id);
    }

    public CustomerEntity getCustomer(UUID id)
    {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        return customerService.getCustomer(id);
    }
}

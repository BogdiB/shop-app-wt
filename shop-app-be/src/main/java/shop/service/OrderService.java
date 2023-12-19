package shop.service;

import shop.entity.LocationEntity;
import shop.entity.OrderEntity;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface OrderService
{
    OrderEntity createOrder(OrderEntity product, Map<UUID, Integer> productToQuantityMap);
    OrderEntity createOrder(OrderEntity product, Map<UUID, Integer> productToQuantityMap, LocationEntity location);
    void updateStockAtLocation(LocationEntity location, Map<UUID, Integer> productToQuantityMap, OrderEntity order);
    OrderEntity getOrder(UUID id);
    Collection<OrderEntity> getOrders();
    void updateOrder(OrderEntity product);
    void deleteOrder(UUID id);

    boolean checkSingleLocation(LocationEntity location, OrderEntity order, Map<UUID, Integer> productToQuantityMap);
    LocationEntity findSingleLocation(OrderEntity order, Map<UUID, Integer> productToQuantityMap);
}

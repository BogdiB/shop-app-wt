package ro.msg.learning.shop.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entity.OrderDetailEntity;
import ro.msg.learning.shop.entity.OrderEntity;
import ro.msg.learning.shop.entity.ProductEntity;
import ro.msg.learning.shop.entity.ids.OrderDetailID;

import java.util.*;

@Mapper
public interface OrderMapper
{
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    //    @Mapping(source = "productEntity.id", target = "productToQuantityMap")
//    @Mapping(source = "orderEntity.orderDetailEntities.quantity", target = "productToQuantityMap")
    @Mapping(source = "orderEntity.createdAt", target = "createdAt")
    @Mapping(source = "orderEntity.country", target = "country")
    @Mapping(source = "orderEntity.city", target = "city")
    @Mapping(source = "orderEntity.county", target = "county")
    @Mapping(source = "orderEntity.street", target = "street")
    OrderDTO toOrderDTO(OrderEntity orderEntity, ProductEntity productEntity);

    @AfterMapping
    default void idAfterMapping(OrderEntity orderEntity, ProductEntity productEntity, @MappingTarget OrderDTO orderDTO)
    {
        orderDTO.getProductToQuantityMap().put(
                productEntity.getOrderDetailEntities().stream().findAny().get().getOrderDetailId().getProduct().getId(),
                orderEntity.getOrderDetailEntities().stream().findAny().get().getQuantity()
        );
    }

    @Mapping(source = "orderEntity.createdAt", target = "createdAt")
    @Mapping(source = "orderEntity.country", target = "country")
    @Mapping(source = "orderEntity.city", target = "city")
    @Mapping(source = "orderEntity.county", target = "county")
    @Mapping(source = "orderEntity.street", target = "street")
    OrderDTO toOrderDTOWithMap(OrderEntity orderEntity, Map<UUID, Integer> productToQuantityMap);

    @AfterMapping
    default void withMapMapping(Map<UUID, Integer> productToQuantityMap, @MappingTarget OrderDTO orderDTO)
    {
        orderDTO.setProductToQuantityMap(productToQuantityMap);
    }

    OrderEntity toOrderEntity(OrderDTO orderDTO);

//    @AfterMapping
//    default void toProductQuantityPair(@MappingTarget OrderEntity order, OrderDTO orderDto)
//    {
//        Set<OrderDetailEntity> orderItems = new HashSet<>();
//
//        orderDto.getProductToQuantityMap()
//                .forEach(
//                        (productIdMap, quantityMap) -> {
//                            OrderDetailEntity orderItem = new OrderDetailEntity();
//                            ProductEntity product = new ProductEntity();
//                            product.setId(productIdMap);
//                            OrderDetailID orderDetailID = new OrderDetailID(order, product);
//                            orderItem.setOrderDetailId(orderDetailID);
//                            orderItem.setQuantity(quantityMap);
//                            orderItems.add(orderItem);
//                        });
//        order.setOrderDetailEntities(orderItems);
//    }
}

package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dto.OrderDTO;
import shop.entity.LocationEntity;
import shop.entity.OrderDetailEntity;
import shop.entity.OrderEntity;
import shop.mapper.OrderMapper;
import shop.service.OrderService;
import shop.service.impl.ProductServiceImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/orders")
public class OrderController
{
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductServiceImpl product;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO)
    {
        OrderEntity order = OrderMapper.INSTANCE.toOrderEntity(orderDTO);
        LocationEntity location = orderService.findSingleLocation(order, orderDTO.getProductToQuantityMap());
        OrderEntity newOrder = orderService.createOrder(order, orderDTO.getProductToQuantityMap(), location);
        return new ResponseEntity<>(OrderMapper.INSTANCE.toOrderDTOWithMap(newOrder, orderDTO.getProductToQuantityMap()), HttpStatus.CREATED);

//        OrderEntity orderEntity = orderService.createOrder(OrderMapper.INSTANCE.toOrderEntity(orderDTO));
//        return new ResponseEntity<>(OrderMapper.INSTANCE.toOrderDTO(orderEntity, orderEntity.getOrderDetailEntities().stream().findAny().get().getOrderDetailId().getProduct()), HttpStatus.CREATED);
    }

    @GetMapping(value = {"/{id}", "/get/{id}"})
    public ResponseEntity<Object> getOrder(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(OrderMapper.INSTANCE.toOrderDTO(orderService.getOrder(id), product.getProduct(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getOrders()
    {
        Collection<OrderEntity> orders = orderService.getOrders();
        Collection<OrderDTO> ordersDTO = new ArrayList<>();
        for (OrderEntity orderEntity : orders)
            ordersDTO.add(OrderMapper.INSTANCE.toOrderDTO(orderEntity, product.getProduct(orderEntity.getId())));
        return new ResponseEntity<>(ordersDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/put/{id}")
    public ResponseEntity<Object> updateOrder(@RequestBody OrderDTO orderDTO)
    {
        orderService.updateOrder(OrderMapper.INSTANCE.toOrderEntity(orderDTO));
        return new ResponseEntity<>("Order is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") UUID id)
    {
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Order is deleted successfully", HttpStatus.OK);
    }
}

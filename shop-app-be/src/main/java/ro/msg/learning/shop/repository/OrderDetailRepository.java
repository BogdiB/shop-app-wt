package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.entity.OrderDetailEntity;
import ro.msg.learning.shop.entity.ids.OrderDetailID;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailID>
{}

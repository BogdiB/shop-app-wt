package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.entity.OrderDetailEntity;
import shop.entity.ids.OrderDetailID;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailID>
{}

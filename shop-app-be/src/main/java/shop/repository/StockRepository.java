package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.entity.StockEntity;
import shop.entity.ids.StockID;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, StockID>
{}

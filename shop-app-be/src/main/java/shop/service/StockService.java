package shop.service;

import shop.entity.StockEntity;
import shop.entity.ids.StockID;
import java.util.Collection;

public interface StockService
{
    void createStock(StockEntity stock);
    StockEntity getStock(StockID stockID);
    Collection<StockEntity> getStock();
    void updateStock(StockEntity stock);
    void deleteStock(StockID stockID);
}

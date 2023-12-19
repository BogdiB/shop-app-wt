package ro.msg.learning.shop.service;

import ro.msg.learning.shop.entity.StockEntity;
import ro.msg.learning.shop.entity.ids.StockID;

import java.util.Collection;

public interface StockService
{
    void createStock(StockEntity stock);
    StockEntity getStock(StockID stockID);
    Collection<StockEntity> getStock();
    void updateStock(StockEntity stock);
    void deleteStock(StockID stockID);
}

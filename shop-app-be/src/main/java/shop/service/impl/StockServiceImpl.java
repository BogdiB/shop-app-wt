package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.StockEntity;
import shop.entity.ids.StockID;
import shop.repository.StockRepository;
import shop.service.StockService;
import java.util.Collection;

@Service
public class StockServiceImpl implements StockService
{
    @Autowired
    private StockRepository stockRepo;

    @Override
    public void createStock(StockEntity stock)
    {
        stockRepo.save(stock);
    }

    @Override
    public StockEntity getStock(StockID stockID)
    {
        return stockRepo.getReferenceById(stockID);
    }

    @Override
    public Collection<StockEntity> getStock()
    {
        return stockRepo.findAll();
    }

    @Override
    public void updateStock(StockEntity stock)
    {
        stockRepo.save(stock);
    }

    @Override
    public void deleteStock(StockID stockID)
    {
        stockRepo.deleteById(stockID);
    }
}

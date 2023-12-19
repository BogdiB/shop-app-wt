package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.ProductEntity;
import shop.repository.ProductRepository;
import shop.service.ProductService;
import java.util.Collection;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepository productRepo;

    @Override
    public void createProduct(ProductEntity product)
    {
        productRepo.save(product);
    }
    @Override
    public ProductEntity getProduct(UUID id)
    {
        return productRepo.getReferenceById(id);
    }

    @Override
    public Collection<ProductEntity> getProducts()
    {
        return productRepo.findAll();
    }

    @Override
    public void updateProduct(ProductEntity product)
    {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(UUID id)
    {
        productRepo.deleteById(id);
    }
}

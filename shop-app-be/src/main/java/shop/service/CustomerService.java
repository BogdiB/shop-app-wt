package shop.service;

import shop.entity.CustomerEntity;
import java.util.Collection;
import java.util.UUID;

public interface CustomerService
{
    void createCustomer(CustomerEntity customer);
    CustomerEntity getCustomer(UUID id);
    Collection<CustomerEntity> getCustomer();
    void updateCustomer(CustomerEntity customer);
    void deleteCustomer(UUID id);
}

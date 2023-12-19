package shop.service.impl;


import org.springframework.stereotype.Service;
import shop.entity.CustomerEntity;
import shop.repository.CustomerRepository;
import shop.service.CustomerService;
import java.util.Collection;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService
{
    private CustomerRepository customerRepo;

    @Override
    public void createCustomer(CustomerEntity customer)
    {
        customerRepo.save(customer);
    }

    @Override
    public CustomerEntity getCustomer(UUID id)
    {
        return customerRepo.getReferenceById(id);
    }

    @Override
    public Collection<CustomerEntity> getCustomer()
    {
        return customerRepo.findAll();
    }

    @Override
    public void updateCustomer(CustomerEntity customer)
    {
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(UUID id)
    {
        customerRepo.deleteById(id);
    }
}

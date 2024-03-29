package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.LocationEntity;
import shop.repository.LocationRepository;
import shop.service.LocationService;
import java.util.Collection;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService
{
    @Autowired
    private LocationRepository locationRepo;

    @Override
    public void createLocation(LocationEntity location)
    {
        locationRepo.save(location);
    }

    @Override
    public LocationEntity getCustomer(UUID id)
    {
        return locationRepo.getReferenceById(id);
    }

    @Override
    public Collection<LocationEntity> getLocation()
    {
        return locationRepo.findAll();
    }

    @Override
    public void updateLocation(LocationEntity location)
    {
        locationRepo.save(location);
    }

    @Override
    public void deleteLocation(UUID id)
    {
        locationRepo.deleteById(id);
    }
}

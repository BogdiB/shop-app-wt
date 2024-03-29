package shop.service;

import shop.entity.LocationEntity;
import java.util.Collection;
import java.util.UUID;

public interface LocationService
{
    void createLocation(LocationEntity location);
    LocationEntity getCustomer(UUID id);
    Collection<LocationEntity> getLocation();
    void updateLocation(LocationEntity location);
    void deleteLocation(UUID id);
}

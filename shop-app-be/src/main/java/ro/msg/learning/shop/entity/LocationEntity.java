package ro.msg.learning.shop.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationEntity extends BaseEntity
{
    @OneToMany(mappedBy = "stockID.location", cascade = CascadeType.ALL)
    private List<StockEntity> stock = new ArrayList<>();

    @OneToMany(mappedBy = "shippedFrom")
    private Set<OrderDetailEntity> orderD;

    private String name;
    // address
    private String country;
    private String city;
    private String county;
    private String street;

    public void addStock(final StockEntity stockEntity)
    {
        stock.add(stockEntity);
        stockEntity.getStockID().setLocation(this);
    }
}

package shop.entity.ids;

import jakarta.persistence.*;
import lombok.Data;
import shop.entity.LocationEntity;
import shop.entity.ProductEntity;

import java.io.Serializable;

@Data
@Embeddable
public class StockID implements Serializable
{
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductEntity product;
    @ManyToOne(cascade = CascadeType.ALL)
    private LocationEntity location;
}

package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.*;
import ro.msg.learning.shop.entity.ids.StockID;

@Entity
@Table(name = "stock")
@Data @NoArgsConstructor @AllArgsConstructor
public class StockEntity
{
    @EmbeddedId
    private StockID stockID;
    private int quantity;
}

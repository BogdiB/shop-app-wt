package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDTO
{
    // IDs
    private UUID productID;
    private UUID categoryID;
    // product attributes
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private double productWeight;
    private String productImageURL;
    // product Category attributes
    private String categoryName;
    private String categoryDescription;
}

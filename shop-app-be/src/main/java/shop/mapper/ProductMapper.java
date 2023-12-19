package ro.msg.learning.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entity.ProductEntity;

@Mapper
public interface ProductMapper
{
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    // product Category mapping
    @Mapping(source = "p.category.id", target = "categoryID")
    @Mapping(source = "p.category.name", target = "categoryName")
    @Mapping(source = "p.category.description", target = "categoryDescription")
    // product mapping
    @Mapping(source = "p.id", target = "productID")
    @Mapping(source = "p.name", target = "productName")
    @Mapping(source = "p.description", target = "productDescription")
    @Mapping(source = "p.price", target = "productPrice")
    @Mapping(source = "p.weight", target = "productWeight")
    @Mapping(source = "p.imageURL", target = "productImageURL")
    ProductDTO toProductDTO(ProductEntity p);

    // product Category mapping
    @Mapping(source = "categoryID", target = "category.id") // or for target "ProductCategoryEntity.id"
    @Mapping(source = "categoryName", target = "category.name")
    @Mapping(source = "categoryDescription", target = "category.description")
    // product mapping
    @Mapping(source = "productID", target = "id")
    @Mapping(source = "productName", target = "name")
    @Mapping(source = "productDescription", target = "description")
    @Mapping(source = "productPrice", target = "price")
    @Mapping(source = "productWeight", target = "weight")
    @Mapping(source = "productImageURL", target = "imageURL")
    ProductEntity toProductEntity(ProductDTO pacDTO);
}

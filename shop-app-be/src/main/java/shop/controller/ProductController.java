package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dto.ProductDTO;
import shop.entity.ProductEntity;
import shop.mapper.ProductMapper;
import shop.service.ProductService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/products")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody ProductDTO pac)
    {
        productService.createProduct(ProductMapper.INSTANCE.toProductEntity(pac));
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @GetMapping(value = {"/{id}", "/get/{id}"})
    public ResponseEntity<Object> getProduct(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(ProductMapper.INSTANCE.toProductDTO(productService.getProduct(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getProducts()
    {
        Collection<ProductEntity> prods = productService.getProducts();
        Collection<ProductDTO> prodsDTO = new ArrayList<>();
        for (ProductEntity productEntity : prods)
            prodsDTO.add(ProductMapper.INSTANCE.toProductDTO(productEntity));
        return new ResponseEntity<>(prodsDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/put/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDTO pac)
    {
        productService.updateProduct(ProductMapper.INSTANCE.toProductEntity(pac));
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") UUID id)
    {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
}

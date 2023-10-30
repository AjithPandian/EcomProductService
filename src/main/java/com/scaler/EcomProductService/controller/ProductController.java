package com.scaler.EcomProductService.controller;


import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService; // Making it as final since it is Immutable

    /*Field injection
    //    @Autowired
    //    @Qualifier("fakeStoreProductService")
    //    private ProductService productService;
     */

    /* Constructor Injection */
    @Autowired // This is now optional for constructor from Spring versions above 4
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity getAllproducts() {
        /*
        ProductResponseDTO p1 =  new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("Iphone 15 pro");
        p1.setPrice(150000);
        p1.setImage("www.google.com/images/iphone");
        p1.setCategory("Electronics");
        p1.setDescription("The best out of the market");

        ProductResponseDTO p2 =  new ProductResponseDTO();
        p2.setId(2);
        p2.setTitle("Samsung S22 Ultra");
        p2.setPrice(125000);
        p2.setImage("www.google.com/images/samsung");
        p2.setCategory("Electronics");
        p2.setDescription("Ready to experience the feel of galaxy");

        List<ProductResponseDTO> products = Arrays.asList(p1, p2);
        return ResponseEntity.ok(products);
         */
        ProductListResponseDTO response = productService.getAllProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductFromId(@PathVariable("id") int id) {
        ProductResponseDTO response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO response = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") int id) {
        boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }
}

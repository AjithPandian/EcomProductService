package com.scaler.EcomProductService.controller;


import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

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

    @GetMapping("/products/1")
    public ResponseEntity getProductFromId() {
        ProductResponseDTO response = productService.getProductById(1);
        return ResponseEntity.ok(response);
    }

}

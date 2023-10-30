package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO[]> productResponseArray =
                restTemplate.getForEntity(getAllProductsURL, ProductResponseDTO[].class);

        ProductListResponseDTO responseDTO = new ProductListResponseDTO();
        for(ProductResponseDTO productResponse: productResponseArray.getBody()) {
            responseDTO.getProducts().add(productResponse);
        }
        return responseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        String getProductByIdURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse =
                restTemplate.getForEntity(getProductByIdURL, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
        String createProductURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> response =
                restTemplate.postForEntity(createProductURL, product, ProductResponseDTO.class);
        return response.getBody();
    }

    @Override
    public boolean deleteProduct(int id) {
        String deleteProductURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
        return true;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}

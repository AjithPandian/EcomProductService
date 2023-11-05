package com.scaler.EcomProductService.client;

import com.scaler.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.scaler.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.scaler.EcomProductService.exception.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {
        String createProductURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> response =
                restTemplate.postForEntity(createProductURL, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return response.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id) {
        String getProductByIdURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> response =
                restTemplate.getForEntity(getProductByIdURL, FakeStoreProductResponseDTO.class);
        return response.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> response =
                restTemplate.getForEntity(getAllProductsURL, FakeStoreProductResponseDTO[].class);
        return List.of(response.getBody());
    }

    public void deleteProduct(int id) {
        String deleteProductURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
    }
}

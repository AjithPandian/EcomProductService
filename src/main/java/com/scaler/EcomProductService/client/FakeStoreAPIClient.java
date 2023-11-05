package com.scaler.EcomProductService.client;

import com.scaler.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.scaler.EcomProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreApiURL;

    @Value("${fakestore.api.path.products}")
    private String fakeStoreAPIProductURL;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreApiURL) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreApiURL = fakeStoreApiURL;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {
        String createProductURL = fakeStoreApiURL + fakeStoreAPIProductURL;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> response =
                restTemplate.postForEntity(createProductURL, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return response.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id) {
        String getProductByIdURL = fakeStoreApiURL + fakeStoreAPIProductURL + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> response =
                restTemplate.getForEntity(getProductByIdURL, FakeStoreProductResponseDTO.class);
        return response.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        String getAllProductsURL = fakeStoreApiURL + fakeStoreAPIProductURL;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> response =
                restTemplate.getForEntity(getAllProductsURL, FakeStoreProductResponseDTO[].class);
        return List.of(response.getBody());
    }

    public void deleteProduct(int id) {
        String deleteProductURL = fakeStoreApiURL + fakeStoreAPIProductURL + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
    }
}

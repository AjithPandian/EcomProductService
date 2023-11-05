package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.client.FakeStoreAPIClient;
import com.scaler.EcomProductService.dto.*;
import com.scaler.EcomProductService.exception.ProductNotFoundException;
import com.scaler.EcomProductService.model.Product;

import org.springframework.stereotype.Service;

import static com.scaler.EcomProductService.mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.scaler.EcomProductService.mapper.ProductMapper.fakeStoreProductResponseToProductResponse;
import static com.scaler.EcomProductService.util.ProductUtils.isNull;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl( FakeStoreAPIClient fakeStoreAPIClient) {
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOS = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO: fakeStoreProductResponseDTOS) {
            productListResponseDTO.getProducts().add(fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        if(isNull(fakeStoreProductResponseDTO)) {
            throw new ProductNotFoundException("Product not found with id: "+ id);
        }
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(product);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
        fakeStoreAPIClient.deleteProduct(id);
        return true;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}

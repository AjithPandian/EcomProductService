package com.scaler.EcomProductService.mapper;

import com.scaler.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.scaler.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;

public class ProductMapper {
    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequest(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        return fakeStoreProductRequestDTO;
    }

    public static ProductResponseDTO fakeStoreProductResponseToProductResponse(FakeStoreProductResponseDTO fakeStoreProductResponseDTO) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        return  productResponseDTO;
    }
}

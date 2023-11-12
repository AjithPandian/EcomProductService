package com.scaler.EcomProductService.repository;

import com.scaler.EcomProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
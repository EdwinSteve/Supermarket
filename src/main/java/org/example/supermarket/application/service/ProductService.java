package org.example.supermarket.application.service;

import org.example.supermarket.application.dto.CreateProduct;
import org.example.supermarket.application.dto.ProductDto;
import org.example.supermarket.application.dto.ProductInfo;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDto> findAll();
    ProductInfo findById(UUID id);
    ProductDto create(CreateProduct product);
    ProductDto update(ProductInfo productInfo, UUID id);
    void delete(UUID id);
}

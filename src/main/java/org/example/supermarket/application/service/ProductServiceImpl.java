package org.example.supermarket.application.service;

import lombok.RequiredArgsConstructor;
import org.example.supermarket.application.dto.CreateProduct;
import org.example.supermarket.application.dto.ProductDto;
import org.example.supermarket.application.dto.ProductInfo;
import org.example.supermarket.application.mapper.ProductMapper;
import org.example.supermarket.domain.entity.Product;
import org.example.supermarket.domain.exception.ProductNotFoundException;
import org.example.supermarket.domain.repository.ProductRepository;
import org.example.supermarket.utils.ErrorCatalog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    private final ProductMapper mapper;

    @Override
    public List<ProductDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public ProductInfo findById(UUID id) {
        return mapper.toInfo(repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(
                        ErrorCatalog.PRODUCT_NOT_FOUND.getMessage())));
    }

    @Override
    public ProductDto create(CreateProduct createProduct) {
        Product product = mapper.toEntity(createProduct);
        product.setUnitOnOrder(0);
        return mapper.toDto(repository.save(product));
    }

    @Override
    public ProductDto update(ProductInfo productInfo, UUID id) {
        return mapper.toDto(repository.findById(id)
                .map(savedProduct -> {
                  savedProduct.setProductCode(productInfo.getProductCode());
                  savedProduct.setProductName(productInfo.getProductName());
                  savedProduct.setProductPicture(productInfo.getProductPicture());
                  savedProduct.setUnitOnStock(productInfo.getUnitOnStock());
                  savedProduct.setUnitOnOrder(productInfo.getUnitOnOrder());
                  savedProduct.setBuyPrice(productInfo.getBuyPrice());
                  savedProduct.setSellPrice(productInfo.getSellPrice());
                  savedProduct.setCategory(categoryService.getById(productInfo.getCategoryId()));
                  savedProduct.setSupplier(supplierService.getById(productInfo.getSupplierId()));
                  return repository.save(savedProduct);
                })
                .orElseThrow(() -> new ProductNotFoundException(
                        ErrorCatalog.PRODUCT_NOT_FOUND.getMessage())));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

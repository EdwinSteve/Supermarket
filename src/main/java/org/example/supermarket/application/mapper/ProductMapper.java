package org.example.supermarket.application.mapper;

import org.example.supermarket.application.dto.CreateProduct;
import org.example.supermarket.application.dto.ProductDto;
import org.example.supermarket.application.dto.ProductInfo;
import org.example.supermarket.domain.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    ModelMapper modelMapper = new ModelMapper();

    public List<ProductDto> toDtoList(List<Product> products) {
        return products.stream().map(this::toDto).toList();
    }

    public Product toEntity(CreateProduct createProduct) {
        return modelMapper.map(createProduct, Product.class);
    }

    public ProductDto toDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        productDto.setCategory(product.getCategory().getCategoryName());
        productDto.setSupplier(product.getSupplier().getCompanyName());
        return productDto;
    }

    public ProductInfo toInfo(Product product) {
        ProductInfo productInfo = modelMapper.map(product, ProductInfo.class);
        productInfo.setCategoryId(product.getCategory().getId());
        productInfo.setSupplierId(product.getSupplier().getId());
        return productInfo;
    }
}

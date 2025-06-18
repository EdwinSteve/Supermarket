package org.example.supermarket.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.supermarket.domain.entity.Category;
import org.example.supermarket.domain.entity.Supplier;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProduct {
    private String productCode;
    private String productName;
    private String productPicture;
    private Integer unitOnStock;
    private Double buyPrice;
    private Double sellPrice;
    private Category category;
    private Supplier supplier;
}

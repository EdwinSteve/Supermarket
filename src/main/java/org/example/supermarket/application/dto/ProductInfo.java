package org.example.supermarket.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductInfo {
    private String productCode;
    private String productName;
    private String productPicture;
    private Integer unitOnStock;
    private Integer unitOnOrder;
    private Double buyPrice;
    private Double sellPrice;
    private Integer categoryId;
    private Integer supplierId;
}

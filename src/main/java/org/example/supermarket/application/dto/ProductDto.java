package org.example.supermarket.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private UUID id;
    private String productCode;
    private String productName;
    private String productPicture;
    private Integer unitOnStock;
    private Integer unitOnOrder;
    private Double buyPrice;
    private Double sellPrice;
    private String category;
    private String supplier;
}

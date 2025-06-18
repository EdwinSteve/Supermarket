package org.example.supermarket.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierDto {
    private Integer id;
    private String companyName;
    private String companyTitle;
    private String contactName;
    private String phone;
    private String addressSupplier;
}

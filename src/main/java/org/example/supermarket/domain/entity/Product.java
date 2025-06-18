package org.example.supermarket.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Column(name = "id_product")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "product_code", nullable = false, unique = true)
    private String productCode;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_picture", nullable = false)
    private String productPicture;

    @Column(name = "unit_on_stock", nullable = false)
    private Integer unitOnStock;

    @Column(name = "unit_on_order", nullable = false)
    private Integer unitOnOrder;

    @Column(name = "buy_price", nullable = false)
    private Double buyPrice;

    @Column(name = "sell_price", nullable = false)
    private Double sellPrice;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;
}

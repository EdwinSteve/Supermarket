package org.example.supermarket.application.service;

import org.example.supermarket.application.dto.SupplierDto;
import org.example.supermarket.domain.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<SupplierDto> findAll();
    SupplierDto findById(Integer id);
    Supplier getById(Integer id);
    SupplierDto create(SupplierDto supplier);
    SupplierDto update(Integer id, SupplierDto supplier);
    void delete(Integer id);
}

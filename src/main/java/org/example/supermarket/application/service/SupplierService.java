package org.example.supermarket.application.service;

import org.example.supermarket.domain.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findAll();
    Supplier findById(Integer id);
    Supplier create(Supplier supplier);
    Supplier update(Integer id, Supplier supplier);
    void delete(Integer id);
}

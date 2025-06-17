package org.example.supermarket.application.service;

import lombok.RequiredArgsConstructor;
import org.example.supermarket.domain.entity.Supplier;
import org.example.supermarket.domain.exception.BadRequestException;
import org.example.supermarket.domain.exception.SupplierNotFoundException;
import org.example.supermarket.domain.repository.SupplierRepository;
import org.example.supermarket.utils.ErrorCatalog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository repository;

    @Override
    public List<Supplier> findAll() {
        return repository.findAll();
    }

    @Override
    public Supplier findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException(
                        ErrorCatalog.RESOURCE_NOT_FOUND.getMessage()));
    }

    @Override
    public Supplier create(Supplier supplier) {
        validateSupplierFields(supplier);
        return repository.save(supplier);
    }

    @Override
    public Supplier update(Integer id, Supplier supplier) {
        return repository.findById(id)
                .map(savedSupplier -> {
                    validateSupplierFields(supplier);
                    savedSupplier.setCompanyName(supplier.getCompanyName());
                    savedSupplier.setCompanyTitle(supplier.getCompanyTitle());
                    savedSupplier.setContactName(supplier.getContactName());
                    savedSupplier.setPhone(supplier.getPhone());
                    savedSupplier.setAddressSupplier(supplier.getAddressSupplier());
                    return repository.save(savedSupplier);
                })
                .orElseThrow(() -> new SupplierNotFoundException(
                        ErrorCatalog.RESOURCE_NOT_FOUND.getMessage()));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private void validateSupplierFields(Supplier supplier) {
        if (supplier.getCompanyName() == null || supplier.getCompanyName().isBlank()) {
            throw new BadRequestException(ErrorCatalog.BAD_REQUEST.getMessage());
        }

        if (supplier.getCompanyTitle() == null || supplier.getCompanyTitle().isBlank()) {
            throw new BadRequestException(ErrorCatalog.BAD_REQUEST.getMessage());
        }

        if (supplier.getContactName() == null || supplier.getContactName().isBlank()) {
            throw new BadRequestException(ErrorCatalog.BAD_REQUEST.getMessage());
        }

        if (supplier.getPhone() == null || supplier.getPhone().isBlank()) {
            throw new BadRequestException(ErrorCatalog.BAD_REQUEST.getMessage());
        }

        if (supplier.getAddressSupplier() == null || supplier.getAddressSupplier().isBlank()) {
            throw new BadRequestException(ErrorCatalog.BAD_REQUEST.getMessage());
        }
    }
}

package org.example.supermarket.application.service;

import lombok.RequiredArgsConstructor;
import org.example.supermarket.application.dto.SupplierDto;
import org.example.supermarket.application.mapper.SupplierMapper;
import org.example.supermarket.domain.entity.Supplier;
import org.example.supermarket.domain.exception.SupplierNotFoundException;
import org.example.supermarket.domain.repository.SupplierRepository;
import org.example.supermarket.utils.ErrorCatalog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class
SupplierServiceImpl implements SupplierService {
    private final SupplierRepository repository;
    private final SupplierMapper mapper;

    @Override
    public List<SupplierDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public SupplierDto findById(Integer id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException(
                        ErrorCatalog.SUPPLIER_NOT_FOUND.getMessage())));
    }

    @Override
    public Supplier getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException(
                        ErrorCatalog.SUPPLIER_NOT_FOUND.getMessage()));
    }

    @Override
    public SupplierDto create(SupplierDto supplier) {
        return mapper.toDto(repository.save(mapper.toEntity(supplier)));
    }

    @Override
    public SupplierDto update(Integer id, SupplierDto supplier) {
        return mapper.toDto(repository.findById(id)
                .map(savedSupplier -> {
                    savedSupplier.setCompanyName(supplier.getCompanyName());
                    savedSupplier.setCompanyTitle(supplier.getCompanyTitle());
                    savedSupplier.setContactName(supplier.getContactName());
                    savedSupplier.setPhone(supplier.getPhone());
                    savedSupplier.setAddressSupplier(supplier.getAddressSupplier());
                    return repository.save(savedSupplier);
                })
                .orElseThrow(() -> new SupplierNotFoundException(
                        ErrorCatalog.SUPPLIER_NOT_FOUND.getMessage())));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

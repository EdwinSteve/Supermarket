package org.example.supermarket.application.mapper;

import org.example.supermarket.application.dto.SupplierDto;
import org.example.supermarket.domain.entity.Supplier;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SupplierMapper {
    ModelMapper modelMapper = new ModelMapper();

    public List<SupplierDto> toDtoList(List<Supplier> suppliers) {
        return modelMapper.map(suppliers, new TypeToken<List<SupplierDto>>() {}.getType());
    }

    public SupplierDto toDto(Supplier supplier) {
        return modelMapper.map(supplier, SupplierDto.class);
    }

    public Supplier toEntity(SupplierDto supplierDto) {
        return modelMapper.map(supplierDto, Supplier.class);
    }
}

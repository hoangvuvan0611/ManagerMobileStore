package com.example.managermobilestore.services;

import com.example.managermobilestore.domain.entities.Supplier;
import com.example.managermobilestore.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findBySupplierNameStartsWith("");
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public Supplier saveNewSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}

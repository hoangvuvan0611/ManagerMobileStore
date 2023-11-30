package com.example.managermobilestore.services;

import com.example.managermobilestore.domain.entities.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier> findAll();
    Optional<Supplier> findById(Long id);
    Supplier saveNewSupplier(Supplier supplier);
}

package com.example.managermobilestore.services;

import com.example.managermobilestore.domain.entities.Supplier;
import com.example.managermobilestore.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SupplierServiceImplTest {

    @Autowired
    SupplierRepository supplierRepository;

    Supplier supplier;

    @BeforeEach
    void setUp() {
        supplier = supplierRepository.findAll().get(0);
    }

    @Test
    void findAll() {
        List<Supplier> supplierList = supplierRepository.findAll();

        assertThat(supplierList.size()).isEqualTo(3);
    }

    @Test
    void findById() {
        Optional<Supplier> supplier1 = supplierRepository.findById(supplier.getId());
        assertThat(supplier1.get().getId()).isEqualTo(supplier1.get().getId());
    }

    @Test
    void saveNewSupplier() {
        Supplier supplierNew = Supplier.builder()
                .supplierName("SupplierNew")
                .address("Test")
                .build();

        supplierRepository.save(supplierNew);
        int size = supplierRepository.findAll().size();
        assertThat(size).isEqualTo(4);
    }
}
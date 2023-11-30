package com.example.managermobilestore.controller;

import com.example.managermobilestore.domain.entities.Supplier;
import com.example.managermobilestore.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("/list")
    ResponseEntity<List<Object>> getList(){
        List<Supplier> list = supplierService.findAll();
        return ResponseEntity.ok().body(Collections.singletonList(list));
    }

    @PostMapping("/create")
    ResponseEntity<Object> createNewSupplier() throws URISyntaxException {
        Supplier supplier = Supplier.builder()
                .supplierName("supplier1")
                .address("Hp")
                .build();
        Supplier supplier1 = supplierService.saveNewSupplier(supplier);
        return ResponseEntity.ok(supplier1);
    }
}

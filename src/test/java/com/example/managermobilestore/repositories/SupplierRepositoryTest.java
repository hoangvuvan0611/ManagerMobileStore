package com.example.managermobilestore.repositories;

//import com.example.managermobilestore.bootstrap.BootstrapData;
import com.example.managermobilestore.domain.entities.Supplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Import(BootstrapData.class)
class SupplierRepositoryTest {

    @Autowired
    SupplierRepository supplierRepository;

    @Test
    void getAll(){
        List<Supplier> supplierList = supplierRepository.findAll();
        assertThat(supplierList.size()).isEqualTo(3);
    }
}
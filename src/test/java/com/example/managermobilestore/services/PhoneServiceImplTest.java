package com.example.managermobilestore.services;

import com.example.managermobilestore.domain.entities.Phone;
import com.example.managermobilestore.domain.entities.Supplier;
import com.example.managermobilestore.repositories.PhoneRepository;
import com.example.managermobilestore.repositories.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@WebMvcTest
class PhoneServiceImplTest {

    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    MockMvc mockMvc;

    Supplier supplier;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void saveNewPhone() {
        Phone phone = getPhone();
        phone.setSupplier(supplier);
        phoneRepository.save(phone);

        Optional<Phone> phone1 = phoneRepository.findById(phone.getId());

        assertThat(phone1.get()).isNull();
        System.out.println(phone1);
    }

    Phone getPhone(){
        Phone phone = Phone.builder()
                .phoneName("Phone1")
                .price(new BigDecimal(56456))
                .build();
        return phone;
    }
}
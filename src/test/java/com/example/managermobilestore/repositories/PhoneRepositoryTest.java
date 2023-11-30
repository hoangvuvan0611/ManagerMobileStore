package com.example.managermobilestore.repositories;

//import com.example.managermobilestore.bootstrap.BootstrapData;
import com.example.managermobilestore.domain.entities.Phone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
//@Import(BootstrapData.class)
class PhoneRepositoryTest {

    @Autowired
    PhoneRepository phoneRepository;

    @Test
    void findAllByQuery() {
        Optional<Phone> phoneList = phoneRepository.findById(Long.valueOf(1l));
        assertThat(phoneList.get().getPhoneName()).isEqualTo(3);
    }
}
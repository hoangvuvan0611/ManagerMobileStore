package com.example.managermobilestore.repositories;

import com.example.managermobilestore.domain.entities.Phone;
import com.example.managermobilestore.domain.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query(value = "select * from suppliers", nativeQuery = true)
    Collection<Supplier> findAllByQuery();

    List<Supplier> findBySupplierNameStartsWith(String perfix);
}

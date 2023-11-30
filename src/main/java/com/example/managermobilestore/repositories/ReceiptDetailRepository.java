package com.example.managermobilestore.repositories;

import com.example.managermobilestore.domain.entities.ReceiptDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, Long> {
}

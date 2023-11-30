package com.example.managermobilestore.domain.model;

import com.example.managermobilestore.domain.entities.BillDetail;
import com.example.managermobilestore.domain.entities.ReceiptDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDTO {
    private String phoneName;
    private Integer quantity;
    private BigDecimal price;
    private Timestamp createDate;
    private Collection<BillDetail> bills;
    private Collection<ReceiptDetail> receipts;
}

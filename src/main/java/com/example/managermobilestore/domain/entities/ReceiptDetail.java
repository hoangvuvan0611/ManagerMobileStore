package com.example.managermobilestore.domain.entities;

import com.example.managermobilestore.domain.embeddables.ReceiptDetailId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receipts_details")
public class ReceiptDetail {
    @EmbeddedId
    ReceiptDetailId receiptDetailId = new ReceiptDetailId();

    @ManyToOne
    @MapsId("receiptId")
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @ManyToOne
    @MapsId("phoneId")
    @JoinColumn(name = "phone_id")
    private Phone phone;

    @Column(name = "phone_name")
    private String phoneName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}

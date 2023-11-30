package com.example.managermobilestore.domain.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ReceiptDetailId {
    @Column(name = "receipt_id")
    private Long receiptId;

    @Column(name = "phone_id")
    private Long phoneId;
}

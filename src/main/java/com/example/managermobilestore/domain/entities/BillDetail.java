package com.example.managermobilestore.domain.entities;

import com.example.managermobilestore.domain.embeddables.BillDetailId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bill_details")
@NoArgsConstructor
@Data
public class BillDetail {

    @EmbeddedId
    BillDetailId billDetailId = new BillDetailId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("phoneId")
    @JoinColumn(name = "phone_id")
    @JsonIgnore
    Phone phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("billId")
    @JoinColumn(name = "bill_id")
    @JsonIgnore
    Bill bill;

    @Column(name = "quantity")
    private Integer quantity;
}




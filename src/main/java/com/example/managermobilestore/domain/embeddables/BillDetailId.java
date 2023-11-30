package com.example.managermobilestore.domain.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
public class BillDetailId implements Serializable {

    @Column(name = "phone_id")
    private Long phoneId;

    @Column(name = "bill_id")
    Long billId;
}

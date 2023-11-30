package com.example.managermobilestore.domain.request.phone;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdatePhoneRequest {
    private String name;
    private Integer quantity;
    private BigDecimal price;
}

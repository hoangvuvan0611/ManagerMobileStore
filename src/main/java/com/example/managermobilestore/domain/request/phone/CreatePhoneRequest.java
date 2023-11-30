package com.example.managermobilestore.domain.request.phone;

import com.example.managermobilestore.constant.BaseMessageErr;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreatePhoneRequest {

    @Size(min = 8, message = "Name must be more than 8 characters!")
    @NotBlank(message = "Name cannot be blank!")
    private String name;

    @NotNull(message = "Quantity " + BaseMessageErr.ERROR_INPUT_NUMBER)
    private Integer quantity;

    @NotNull(message = "Price " + BaseMessageErr.ERROR_INPUT_NUMBER)
    private BigDecimal price;

    @NotNull(message = "SupplierId " + BaseMessageErr.ERROR_INPUT_NUMBER)
    private Long supplierId;
}

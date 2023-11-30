package com.example.managermobilestore.domain.request.phone;

import com.example.managermobilestore.constant.BaseMessageErr;
import com.example.managermobilestore.validator.date.DateValidateAnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListPhoneMultiElementRequest {

    private String keywordOfNamePhone;

    private Integer quantityStart;

    private Integer quantityLimit;

    private BigDecimal priceStart;

    private BigDecimal priceLimit;

    @DateValidateAnotation(message = "DateFrom" + BaseMessageErr.ERROR_INPUT_DATE)
    private String dateFrom;

    @DateValidateAnotation(message = "DateTo" + BaseMessageErr.ERROR_INPUT_DATE)
    private String dateTo;

    private String keywordOfNameSupplier;

    private Integer pageIndex;

    private Integer pageSize;
}

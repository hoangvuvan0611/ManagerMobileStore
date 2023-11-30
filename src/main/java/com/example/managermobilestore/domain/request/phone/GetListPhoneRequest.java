package com.example.managermobilestore.domain.request.phone;

import com.example.managermobilestore.constant.BaseMessageErr;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetListPhoneRequest {

    @NotNull(message = "PageIndex " + BaseMessageErr.ERROR_INPUT_NULL)
    private Integer pageIndex;

    @NotNull(message = "PageSize " + BaseMessageErr.ERROR_INPUT_NULL)
    private Integer pageSize;
}

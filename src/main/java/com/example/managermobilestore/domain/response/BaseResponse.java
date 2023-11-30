package com.example.managermobilestore.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private boolean success = false;
    private Error error;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Error {
        private Integer codeError;
        private String message;
        private List<ErrorDetail> errorDetails;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ErrorDetail {
        private String fieldError;
        private String message;
    }
}

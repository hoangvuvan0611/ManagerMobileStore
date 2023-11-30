package com.example.managermobilestore.exceptions;

import com.example.managermobilestore.constant.BaseCodeError;
import com.example.managermobilestore.domain.response.BaseResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandle {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse unexpectedException(MethodArgumentNotValidException e) {

        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(false);
        baseResponse.setError(handleFieldError(fieldErrors, BaseCodeError.VALIDATION_ERROR, BaseCodeError.getErrMsg(BaseCodeError.VALIDATION_ERROR)));

        return baseResponse;
    }

    public BaseResponse.Error handleFieldError(List<FieldError> fieldErrors, Integer codeError, String errorMessage) {
        BaseResponse.Error error = BaseResponse.Error.builder()
                .codeError(codeError)
                .message(errorMessage)
                .build();

        List<BaseResponse.ErrorDetail> errorDetails = new ArrayList<>();
        fieldErrors.forEach(fieldError -> {
            BaseResponse.ErrorDetail errorDetail = BaseResponse.ErrorDetail.builder()
                    .fieldError(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
            errorDetails.add(errorDetail);
        });

        error.setErrorDetails(errorDetails);
        return error;
    }

    @ResponseBody
    @ExceptionHandler(CustomNotFoundException.class)
    public BaseResponse notFoundException(CustomNotFoundException e){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(false);

        BaseResponse.Error baseError = handleError(BaseCodeError.NOT_FOUND, BaseCodeError.getErrMsg(BaseCodeError.NOT_FOUND), e.getFieldError(), e.getMessage());
        baseResponse.setError(baseError);

        return baseResponse;

    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseResponse methodArgumentNotValidException(Exception ex) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(false);

        BaseResponse.Error error = handleError(BaseCodeError.SERVER_ERROR, BaseCodeError.getErrMsg(BaseCodeError.SERVER_ERROR), null, ex.getMessage());
        response.setError(error);
        return response;
    }

    BaseResponse.Error handleError(Integer codeError, String getErrMsg, String fieldError, String message){
        BaseResponse.Error error = BaseResponse.Error.builder()
                .codeError(codeError)
                .message(getErrMsg)
                .build();

        BaseResponse.ErrorDetail errorDetail = BaseResponse.ErrorDetail.builder()
                .fieldError(fieldError)
                .message(message)
                .build();

        List<BaseResponse.ErrorDetail> errorDetails = new ArrayList<>();
        errorDetails.add(errorDetail);

        error.setErrorDetails(errorDetails);
        return error;
    }
}

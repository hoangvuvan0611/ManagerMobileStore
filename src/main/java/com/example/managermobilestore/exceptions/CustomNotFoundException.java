package com.example.managermobilestore.exceptions;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomNotFoundException extends RuntimeException{

    private String fieldError;
    public CustomNotFoundException(String message, String fieldError) {
        super(message);
        this.fieldError = fieldError;
    }
}

package com.example.managermobilestore.validator.date;

import com.example.managermobilestore.utils.CustomDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.ParseException;

public class DateValidator implements ConstraintValidator<DateValidateAnotation, String> {
    @Override
    public void initialize(DateValidateAnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
        if (date.isBlank()) {
            return true;
        }
        try {
            return CustomDate.configFormatAndParseDate().parse(date) != null;
        } catch (ParseException e) {
            return false;
        }
    }
}

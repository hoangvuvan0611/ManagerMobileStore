package com.example.managermobilestore.validator.date;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = DateValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface DateValidateAnotation {
    String message() default "Date not valid";

    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}

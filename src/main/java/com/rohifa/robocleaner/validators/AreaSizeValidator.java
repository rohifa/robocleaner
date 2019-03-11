package com.rohifa.robocleaner.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AreaSizeConstraint.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AreaSizeValidator {
    String message() default "Area size cannot have negative elements and must contains 2 values";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.rohifa.robocleaner.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InitialPositionConstraint.class)
@Target( { ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InitialPositionValidator {

    String message() default "initial position must be inside area boundaries";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

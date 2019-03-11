package com.rohifa.robocleaner.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

@Documented
@Constraint(validatedBy = OilPatchesConstraint.class)
@Target( { TYPE, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface OilPatchesValidator {

    String message() default "oil patches must be inside area boundaries";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

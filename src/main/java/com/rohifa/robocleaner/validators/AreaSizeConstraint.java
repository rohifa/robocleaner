package com.rohifa.robocleaner.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AreaSizeConstraint implements ConstraintValidator<AreaSizeValidator, Integer[]> {

   public void initialize(AreaSizeValidator constraint) {

   }

   public boolean isValid(Integer[] areaField, ConstraintValidatorContext context) {
      return areaField.length == 2 && areaField[0] >= 0 && areaField[1] >= 0;
   }
}

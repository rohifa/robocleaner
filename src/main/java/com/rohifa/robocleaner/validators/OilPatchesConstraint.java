package com.rohifa.robocleaner.validators;

import com.rohifa.robocleaner.model.CleaningRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OilPatchesConstraint implements ConstraintValidator<OilPatchesValidator, CleaningRequest> {
   public void initialize(OilPatchesValidator constraint) {
   }

   public boolean isValid(CleaningRequest cleaningRequest, ConstraintValidatorContext context) {

      for (Integer[] patch : cleaningRequest.getOilPatches()) {
         if (patch[0]<0 || patch[1]>cleaningRequest.getAreaSize()[0]) return false;
      }
      return true;

   }
}

package com.rohifa.robocleaner.validators;

import com.rohifa.robocleaner.model.CleaningRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InitialPositionConstraint implements ConstraintValidator<InitialPositionValidator, CleaningRequest> {
   public void initialize(InitialPositionValidator constraint) {
   }

   public boolean isValid(CleaningRequest cleaningRequest, ConstraintValidatorContext context) {

      return cleaningRequest.getStartingPosition()[0]>=0 &&
             cleaningRequest.getStartingPosition()[0]<cleaningRequest.getAreaSize()[0] &&
             cleaningRequest.getStartingPosition()[1]>=0 &&
             cleaningRequest.getStartingPosition()[1]<cleaningRequest.getAreaSize()[1];
   }
}

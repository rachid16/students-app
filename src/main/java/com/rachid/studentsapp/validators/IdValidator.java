package com.rachid.studentsapp.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<ValidId, Integer> {

    private Integer lower;

    @Override
    public void initialize(ValidId id) {
        this.lower = id.lower();
    }

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {

        if(id < lower || id == null)
            return false;
        else
            return true;

    }

}

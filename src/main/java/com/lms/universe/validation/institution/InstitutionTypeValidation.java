package com.lms.universe.validation.institution;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InstitutionTypeValidation implements ConstraintValidator<InstitutionType, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (com.lms.universe.model.InstitutionType typ : com.lms.universe.model.InstitutionType.values()) {
            if (typ.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}

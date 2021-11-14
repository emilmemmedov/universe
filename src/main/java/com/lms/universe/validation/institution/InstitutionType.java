package com.lms.universe.validation.institution;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = InstitutionTypeValidation.class)
public @interface InstitutionType {
    public String message() default "Invalid Institution type";

    public Class<?>[] groups() default {};

    public Class<?extends javax.validation.Payload>[] payload() default {};
}

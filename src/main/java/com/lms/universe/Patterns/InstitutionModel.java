package com.lms.universe.Patterns;

import com.lms.universe.model.InstitutionType;

public abstract class InstitutionModel {
    protected InstitutionType institutionType;

    public abstract void setInstitutionType();

    public InstitutionType getInstitutionType() {
        return institutionType;
    }
}
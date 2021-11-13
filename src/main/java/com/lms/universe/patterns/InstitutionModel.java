package com.lms.universe.patterns;

import com.lms.universe.model.InstitutionType;

public abstract class InstitutionModel {
    protected InstitutionType institutionType;

    public abstract void setInstitutionType();

    public InstitutionType getInstitutionType() {
        return institutionType;
    }
}
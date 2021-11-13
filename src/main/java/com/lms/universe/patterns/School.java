package com.lms.universe.patterns;

import com.lms.universe.model.InstitutionType;

public class School extends InstitutionModel {

    @Override
    public void setInstitutionType() {
        this.institutionType = InstitutionType.SCHOOL;
    }
}

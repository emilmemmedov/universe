package com.lms.universe.Patterns;

import com.lms.universe.model.InstitutionType;

public class University extends InstitutionModel {

    @Override
    public void setInstitutionType() {
        this.institutionType = InstitutionType.UNIVERSITY;
    }
}

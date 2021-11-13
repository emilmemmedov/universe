package com.lms.universe.patterns;

import com.lms.universe.model.InstitutionType;

public class University extends InstitutionModel {

    @Override
    public void setInstitutionType() {
        this.institutionType = InstitutionType.UNIVERSITY;
    }
}

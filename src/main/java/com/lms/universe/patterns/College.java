package com.lms.universe.patterns;

import com.lms.universe.model.InstitutionType;

public class College extends InstitutionModel {

    @Override
    public void setInstitutionType() {
        this.institutionType = InstitutionType.COLLEGE;
    }
}

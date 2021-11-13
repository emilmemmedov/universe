package com.lms.universe.model;

public enum InstitutionType {
    UNIVERSITY, SCHOOL, COLLEGE;

    public boolean checkValid(String type){
        for (InstitutionType typ : InstitutionType.values()) {
            if (typ.name().equals(type)) {
                return true;
            }
        }
        return false;
    }
}

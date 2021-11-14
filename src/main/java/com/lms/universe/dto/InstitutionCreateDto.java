package com.lms.universe.dto;

import lombok.Data;

@Data
public class InstitutionCreateDto{

    private Long id;

    private String name;

    @com.lms.universe.validation.institution.InstitutionType
    private String type;
}

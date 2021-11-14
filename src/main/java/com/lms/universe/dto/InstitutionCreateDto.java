package com.lms.universe.dto;

import com.lms.universe.model.InstitutionType;
import lombok.Data;

@Data
public class InstitutionCreateDto{

    private Long id;

    private String name;

    @com.lms.universe.validation.institution.InstitutionType
    private String type;
}

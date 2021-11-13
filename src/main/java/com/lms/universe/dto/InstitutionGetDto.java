package com.lms.universe.dto;

import com.lms.universe.model.InstitutionType;
import lombok.Data;

import java.util.Date;

@Data
public class InstitutionGetDto{
    private Long id;

    private String name;

    private InstitutionType type;

    private Date createdAt;

    private Date updatedAt;
}

package com.lms.universe.dto;

import com.lms.universe.model.UserType;
import lombok.Data;

@Data
public class UserCreateDto {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    String password;

    UserType userType;
}

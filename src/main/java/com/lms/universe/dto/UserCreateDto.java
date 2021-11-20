package com.lms.universe.dto;

import com.lms.universe.model.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class UserCreateDto{

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private int age;

    String password;

    UserType userType;
}

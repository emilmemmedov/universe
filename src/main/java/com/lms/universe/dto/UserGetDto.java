package com.lms.universe.dto;

import com.lms.universe.model.UserType;
import lombok.Data;
import java.util.Date;

@Data
public class UserGetDto{
    private Long id;

    private String name;

    private String lastName;

    private String email;

    String password;

    UserType userType;

    private Date createdAt;

    private Date updatedAt;
}

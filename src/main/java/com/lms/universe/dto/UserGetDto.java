package com.lms.universe.dto;

import com.lms.universe.model.UserType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class UserGetDto {
    private Long id;

    private String name;

    private String lastName;

    private String email;

    String password;

    UserType userType;

    private Date createdAt;

    private Date updatedAt;
}

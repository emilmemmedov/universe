package com.lms.universe.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    String password;

    @Enumerated
    @Column(name = "type")
    UserType userType;

    @CreationTimestamp
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
}

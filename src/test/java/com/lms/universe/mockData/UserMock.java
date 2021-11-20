package com.lms.universe.mockData;

import com.lms.universe.model.UserType;

public class UserMock {
    private final String name = "Emil";
    private final int studentAge = 19;
    private final int instructorAge = 36;
    private final String lastName = "Memmedov";
    private final UserType adminUser = UserType.ADMIN;
    private final UserType instructorUser = UserType.INSTRUCTOR;
    private final UserType studentUser = UserType.STUDENT;
    private final String email = "emill.memmedovv@gmail.com";
    private final String password = "password9";

    public String getName() {
        return name;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public int getInstructorAge() {
        return instructorAge;
    }

    public String getLastName() {
        return lastName;
    }

    public UserType getAdminUser() {
        return adminUser;
    }

    public UserType getInstructorUser() {
        return instructorUser;
    }

    public UserType getStudentUser() {
        return studentUser;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

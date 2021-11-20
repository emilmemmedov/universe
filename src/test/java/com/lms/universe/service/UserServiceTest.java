package com.lms.universe.service;

import com.lms.universe.dto.UserCreateDto;
import com.lms.universe.mockData.UserMock;
import com.lms.universe.model.UserType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {

    UserMock userMock = new UserMock();

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("create")
    void create(int age, UserType type){
        UserCreateDto given = new UserCreateDto();
        given.setId(12L);
        given.setName(userMock.getName());
        given.setAge(age);
        given.setEmail(userMock.getEmail());
        given.setLastName(userMock.getLastName());
        given.setPassword(userMock.getPassword());
        given = userService.setUserType(given);

        UserCreateDto expected = new UserCreateDto();
        expected.setId(12L);
        expected.setAge(age);
        expected.setName(userMock.getName());
        expected.setEmail(userMock.getEmail());
        expected.setLastName(userMock.getLastName());
        expected.setPassword(userMock.getPassword());
        expected.setUserType(type);

        assertEquals(expected,given);
    }


    private static Stream<Arguments> create(){
        return Stream.of(
                Arguments.of(19, UserType.STUDENT),
                Arguments.of(38, UserType.INSTRUCTOR)
        );
    }
}
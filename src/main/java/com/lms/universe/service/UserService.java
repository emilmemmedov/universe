package com.lms.universe.service;

import com.lms.universe.dto.UserCreateDto;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    UserCreateDto setUserType(UserCreateDto dto);
}

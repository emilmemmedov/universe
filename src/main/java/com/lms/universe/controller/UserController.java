package com.lms.universe.controller;
import com.lms.universe.dto.UserCreateDto;
import com.lms.universe.dto.UserGetDto;
import com.lms.universe.service.ServiceModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController extends Controller<UserGetDto, UserCreateDto>{
    public UserController(ServiceModel<UserGetDto, UserCreateDto> serviceModel) {
        super(serviceModel);
    }
}

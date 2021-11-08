package com.lms.universe.controller;
import com.lms.universe.resource.ApiResource;
import com.lms.universe.resource.Response;
import com.lms.universe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ApiResource apiResource;

    @GetMapping("/")
    public Response index(){
        return apiResource.success(userService.getUsers(),"nothing", HttpStatus.OK.value());
    }
}

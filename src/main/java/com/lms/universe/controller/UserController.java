package com.lms.universe.controller;
import com.lms.universe.dto.UserGetDto;
import com.lms.universe.resource.ApiResource;
import com.lms.universe.resource.ResponseList;
import com.lms.universe.resource.ResponseSingle;
import com.lms.universe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ApiResource apiResource;

    @GetMapping("/")
    public ResponseList index(){
        return apiResource.success(userService.getUsers(),"nothing", HttpStatus.OK.value());
    }

    @GetMapping("/{id}")
    public ResponseSingle show(@PathVariable("id") Long id){
        UserGetDto user = userService.getUserById(id);
        return apiResource.success(user, "nothing", HttpStatus.OK.value());
    }
}

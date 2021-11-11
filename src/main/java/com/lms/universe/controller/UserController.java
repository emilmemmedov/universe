package com.lms.universe.controller;
import com.lms.universe.dto.UserCreateDto;
import com.lms.universe.dto.UserGetDto;
import com.lms.universe.model.User;
import com.lms.universe.resource.ApiResource;
import com.lms.universe.resource.ResponseList;
import com.lms.universe.resource.ResponseSingle;
import com.lms.universe.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final ApiResource apiResource;

    @GetMapping("/")
    public ResponseList index(){
        log.info("fuck me");
        ResponseList responseList = apiResource.success(userService.getUsers(),"nothing", HttpStatus.OK.value());
        log.info("fuck me");
        return responseList;
    }

    @GetMapping("/{id}")
    public ResponseSingle show(@PathVariable("id") Long id){
        UserGetDto user = userService.getUserById(id);
        return apiResource.success(user, "nothing", HttpStatus.OK.value());
    }

    @PostMapping("/")
    public ResponseSingle create(@RequestBody UserCreateDto userCreateDto){
        UserGetDto userGetDto = userService.create(userCreateDto);
        return apiResource.success(userGetDto, "nothing", HttpStatus.OK.value());
    }

    @PutMapping("/{id}")
    public void update(@RequestBody UserCreateDto userCreateDto, @PathVariable("id") Long id){
        userService.update(id, userCreateDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
}

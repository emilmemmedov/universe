package com.lms.universe.controller;
import com.lms.universe.config.CRUD;
import com.lms.universe.dto.UserCreateDto;
import com.lms.universe.dto.UserGetDto;
import com.lms.universe.service.ServiceModel;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
@RequestedCRUD(mapping = {
        CRUD.CREATE,
        CRUD.INDEX,
        CRUD.UPDATE,
        CRUD.SHOW
})
public class UserController extends Controller<UserGetDto, UserCreateDto>{

    public UserController(ServiceModel<UserGetDto, UserCreateDto> serviceModel) {
        super(serviceModel);
    }

}

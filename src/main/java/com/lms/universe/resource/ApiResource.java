package com.lms.universe.resource;

import com.lms.universe.dto.UserGetDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiResource {

    public Response success(List<UserGetDto> data, String message, int status){
        Response response =  new Response();
        response.setData(data);
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }
}

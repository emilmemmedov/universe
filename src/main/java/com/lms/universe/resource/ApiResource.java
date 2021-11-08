package com.lms.universe.resource;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiResource {

    public ResponseList success(List<?> data, String message, int status){
        ResponseList response =  new ResponseList();
        response.setData(data);
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }

    public ResponseSingle success(Object data, String message, int status){
        ResponseSingle response =  new ResponseSingle();
        response.setData(data);
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }
}

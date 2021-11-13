package com.lms.universe.resource;

import com.lms.universe.config.ApplicationConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiResource {

    private final ApplicationConfiguration application;

    public ResponseList success(List<?> data, String message, int status){
        ResponseList response =  new ResponseList();
        response.setData(data);
        response.setMessage(message);
        response.setStatus(status);
        response.setApplication(application);
        return response;
    }

    public ResponseSingle success(Object data, String message, int status){
        ResponseSingle response =  new ResponseSingle();
        response.setData(data);
        response.setMessage(message);
        response.setStatus(status);
        response.setApplication(application);
        return response;
    }
}

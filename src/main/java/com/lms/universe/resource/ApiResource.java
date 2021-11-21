package com.lms.universe.resource;

import com.lms.universe.config.ApplicationConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiResource {

    private final ApplicationConfiguration application;

    public ResponseEntity<ResponseList> success(List<?> data, String message, int status){
        ResponseList response =  new ResponseList();
        response.setData(data);
        response.setMessage(message);
        response.setStatus(status);
        response.setApplication(application);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ResponseSingle> success(Object data, String message, int status){
        ResponseSingle response =  new ResponseSingle();
        response.setData(data);
        response.setMessage(message);
        response.setStatus(status);
        response.setApplication(application);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ErrorResponse> error(String message, int status){
        com.lms.universe.resource.ErrorResponse response =  new com.lms.universe.resource.ErrorResponse();
        response.setMessage(message);
        response.setStatus(status);
        response.setApplication(application);
        return ResponseEntity.ok(response);
    }
}

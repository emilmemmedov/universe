package com.lms.universe.resource;

import com.lms.universe.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class Response {
    List data;
    int status;
    String message;
}

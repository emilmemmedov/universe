package com.lms.universe.resource;

import lombok.Data;

@Data
public class ErrorResponse {
    int status;
    String message;
    Object application;
}

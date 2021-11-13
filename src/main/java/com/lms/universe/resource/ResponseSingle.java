package com.lms.universe.resource;

import lombok.Data;

import java.util.List;

@Data
public class ResponseSingle {
    Object data;
    int status;
    String message;
    Object application;
}

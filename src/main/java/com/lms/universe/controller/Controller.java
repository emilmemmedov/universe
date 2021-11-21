package com.lms.universe.controller;

import com.lms.universe.resource.ApiResource;
import com.lms.universe.resource.ResponseList;
import com.lms.universe.resource.ResponseSingle;
import com.lms.universe.service.ServiceModel;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;


public abstract class Controller<GetDto, CreateDto> {


    @Autowired
    private ApiResource resource;

    private String[] methods;

    private final ServiceModel<GetDto, CreateDto> serviceModel;

    public Controller(final ServiceModel<GetDto, CreateDto> serviceModel) throws NoSuchMethodException {
        this.serviceModel = serviceModel;

        this.methods = super.getClass().getAnnotation(RequestedCRUD.class).mapping();
    }

    @GetMapping("/")
    public ResponseEntity<ResponseList> index() throws NotFoundException {
        isRequested("index");
        return resource.success(serviceModel.index(),"nothing", HttpStatus.OK.value());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSingle> show(@PathVariable("id") Long id) throws NotFoundException {
        isRequested("show");
        GetDto model = serviceModel.show(id);
        return resource.success(model, "nothing", HttpStatus.OK.value());
    }

    @PostMapping("/")
    public ResponseEntity<ResponseSingle> create(@Valid @RequestBody CreateDto data) throws NotFoundException {
        isRequested("create");
        GetDto userGetDto = serviceModel.create(data);
        return resource.success(userGetDto, "nothing", HttpStatus.OK.value());
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CreateDto data, @PathVariable("id") Long id) throws NotFoundException {
        isRequested("update");
        serviceModel.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws NotFoundException {
        isRequested("delete");
        serviceModel.delete(id);
    }

    private void isRequested(String method) throws NotFoundException {
        if (!Arrays.asList(this.methods).contains(method)){
            throw new NotFoundException("not found");
        }
    }
}

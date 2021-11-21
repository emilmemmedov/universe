package com.lms.universe.controller;

import com.lms.universe.config.CRUD;
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
import java.lang.annotation.Annotation;
import java.util.Arrays;


public abstract class Controller<GetDto, CreateDto> {


    @Autowired
    private ApiResource resource;

    private final CRUD[] methods;

    private final ServiceModel<GetDto, CreateDto> serviceModel;

    public Controller(final ServiceModel<GetDto, CreateDto> serviceModel){
        this.serviceModel = serviceModel;
        boolean existAnnotation = Arrays.stream(super.getClass().getAnnotations())
                .map(Annotation::annotationType)
                .map(Class::getSimpleName)
                .anyMatch(name -> name.equals("RequestedCRUD"));

        if (existAnnotation){
            this.methods = super.getClass().getAnnotation(RequestedCRUD.class).mapping();
        }
        else {
            this.methods = new CRUD[]{
                    CRUD.INDEX,
                    CRUD.DELETE,
                    CRUD.UPDATE,
                    CRUD.SHOW,
                    CRUD.CREATE
            };
        }
    }

    @GetMapping("/")
    public ResponseEntity<ResponseList> index() throws NotFoundException {
        isRequested(CRUD.INDEX);
        return resource.success(serviceModel.index(),"nothing", HttpStatus.OK.value());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSingle> show(@PathVariable("id") Long id) throws NotFoundException {
        isRequested(CRUD.SHOW);
        GetDto model = serviceModel.show(id);
        return resource.success(model, "nothing", HttpStatus.OK.value());
    }

    @PostMapping("/")
    public ResponseEntity<ResponseSingle> create(@Valid @RequestBody CreateDto data) throws NotFoundException {
        isRequested(CRUD.CREATE);
        GetDto userGetDto = serviceModel.create(data);
        return resource.success(userGetDto, "nothing", HttpStatus.OK.value());
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CreateDto data, @PathVariable("id") Long id) throws NotFoundException {
        isRequested(CRUD.UPDATE);
        serviceModel.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws NotFoundException {
        isRequested(CRUD.DELETE);
        serviceModel.delete(id);
    }

    private void isRequested(CRUD method) throws NotFoundException {
        if (!Arrays.asList(this.methods).contains(method)){
            throw new NotFoundException("route not defined");
        }
    }
}

package com.lms.universe.controller;

import com.lms.universe.resource.ApiResource;
import com.lms.universe.resource.ResponseList;
import com.lms.universe.resource.ResponseSingle;
import com.lms.universe.service.ServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
public abstract class Controller<GetDto, CreateDto> {

    @Autowired
    private ApiResource resource;

    private final ServiceModel<GetDto, CreateDto> serviceModel;

    @GetMapping("/")
    public ResponseEntity<ResponseList> index(){
        return resource.success(serviceModel.index(),"nothing", HttpStatus.OK.value());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSingle> show(@PathVariable("id") Long id){
        GetDto model = serviceModel.show(id);
        return resource.success(model, "nothing", HttpStatus.OK.value());
    }

    @PostMapping("/")
    public ResponseEntity<ResponseSingle> create(@Valid @RequestBody CreateDto data){
        GetDto userGetDto = serviceModel.create(data);
        return resource.success(userGetDto, "nothing", HttpStatus.OK.value());
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CreateDto data, @PathVariable("id") Long id) {
        serviceModel.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        serviceModel.delete(id);
    }
}

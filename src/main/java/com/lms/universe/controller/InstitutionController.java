package com.lms.universe.controller;
import com.lms.universe.dto.InstitutionCreateDto;
import com.lms.universe.dto.InstitutionGetDto;
import com.lms.universe.dto.UserCreateDto;
import com.lms.universe.dto.UserGetDto;
import com.lms.universe.resource.ApiResource;
import com.lms.universe.resource.ResponseList;
import com.lms.universe.resource.ResponseSingle;
import com.lms.universe.service.ServiceModel;
import com.lms.universe.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/institution")
public class InstitutionController extends Controller<InstitutionGetDto, InstitutionCreateDto>{

    public InstitutionController(ServiceModel<InstitutionGetDto, InstitutionCreateDto> serviceModel) {
        super(serviceModel);
    }
}

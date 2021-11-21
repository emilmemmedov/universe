package com.lms.universe.controller;
import com.lms.universe.dto.InstitutionCreateDto;
import com.lms.universe.dto.InstitutionGetDto;
import com.lms.universe.service.ServiceModel;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/institution")
@RequestedCRUD(mapping = {"index", "post", "show"})
public class InstitutionController extends Controller<InstitutionGetDto, InstitutionCreateDto>{

    public InstitutionController(ServiceModel<InstitutionGetDto, InstitutionCreateDto> serviceModel) throws NoSuchMethodException {
        super(serviceModel);
    }
}

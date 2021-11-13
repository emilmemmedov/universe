package com.lms.universe.service;

import com.lms.universe.Patterns.InstitutionModel;
import com.lms.universe.dto.InstitutionCreateDto;
import com.lms.universe.dto.InstitutionGetDto;
import com.lms.universe.dto.UserGetDto;
import com.lms.universe.exception.ApiException;
import com.lms.universe.model.Institution;
import com.lms.universe.model.InstitutionType;
import com.lms.universe.repository.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstitutionService extends ServiceModel<InstitutionGetDto, InstitutionCreateDto> {

    private final InstitutionRepository institutionRepository;
    private final ModelMapper mapper;

    @Override
    public List<?> index() {
        List<Institution> institutions =  institutionRepository.findAll();

        return institutions.stream()
                .map(institution -> mapper.map(institution, InstitutionGetDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public InstitutionGetDto show(Long id) {
        Institution institution = institutionRepository.findById(id).orElseThrow(()-> new ApiException("id: " + id + " not found"));
        return mapper.map(institution, InstitutionGetDto.class);
    }

    @Override
    public void delete(Long id) {
        Institution institution = institutionRepository.getById(id);
        institutionRepository.delete(institution);
    }

    @Override
    public void update(Long id, InstitutionCreateDto data) {
        data.setId(id);
        Institution institution = mapper.map(data, Institution.class);
        institutionRepository.save(institution);
    }

    @Override
    public InstitutionGetDto create(InstitutionCreateDto data) {
        if (checkValid(data.getType())){
            Institution model = mapper.map(data, Institution.class);
            model.setType(InstitutionType.valueOf(data.getType()));
            Institution institution = institutionRepository.save(model);
            return mapper.map(institution,InstitutionGetDto.class);
        }
        else {
            throw new ApiException("user type not correct");
        }
    }

    public boolean checkValid(String type){
        for (InstitutionType typ : InstitutionType.values()) {
            if (typ.name().equals(type)) {
                return true;
            }
        }
        return false;
    }
}

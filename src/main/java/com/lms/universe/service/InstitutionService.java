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
                .map(user -> mapper.map(institutions, UserGetDto.class))
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
        InstitutionModel institutionModel;
        System.out.println(InstitutionType.valueOf(data.getType().name()));
        return new InstitutionGetDto();

//        data.getType()
//        data.setUserType(UserType.ADMIN);
//        User user = userRepository.save(mapper.map(data, User.class));
//        return mapper.map(user, UserGetDto.class);
    }
}

package com.lms.universe.service;

import com.lms.universe.dto.UserCreateDto;
import com.lms.universe.dto.UserGetDto;
import com.lms.universe.exception.ApiException;
import com.lms.universe.model.User;
import com.lms.universe.model.UserType;
import com.lms.universe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService extends ServiceModel<UserGetDto, UserCreateDto> {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public List<?> index() {
        System.out.println("im in service index");
        List<User> users =  userRepository.findAll();

        return users.stream()
                .map(user -> mapper.map(user, UserGetDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserGetDto show(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ApiException("id: " + id + " not found"));
        return mapper.map(user, UserGetDto.class);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.getById(id);
        userRepository.delete(user);
    }

    @Override
    public void update(Long id, UserCreateDto data) {
        data.setId(id);
        User user = mapper.map(data, User.class);
        userRepository.save(user);
    }

    @Override
    public UserGetDto create(UserCreateDto data) {
        data.setUserType(UserType.ADMIN);
        User user = userRepository.save(mapper.map(data, User.class));
        return mapper.map(user, UserGetDto.class);
    }
}

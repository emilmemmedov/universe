package com.lms.universe.service;

import com.lms.universe.dto.UserGetDto;
import com.lms.universe.exception.ApiException;
import com.lms.universe.model.User;
import com.lms.universe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public List<UserGetDto> getUsers(){
        List<User> users =  userRepository.findAll();
        List<UserGetDto> data = users.stream()
                .map(user -> mapper.map(user, UserGetDto.class))
                .collect(Collectors.toList());

        return data;
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ApiException("id: " + id + " not found"));
        return user;
    }
}

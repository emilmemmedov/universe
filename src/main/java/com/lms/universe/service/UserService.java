package com.lms.universe.service;

import com.lms.universe.dto.UserGetDto;
import com.lms.universe.model.User;
import com.lms.universe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public ResponseEntity<List<UserGetDto>> getUsers(){
        List<User> users =  userRepository.findAll();
        List<UserGetDto> data = users.stream()
                .map(user -> mapper.map(user, UserGetDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(data);
    }
}

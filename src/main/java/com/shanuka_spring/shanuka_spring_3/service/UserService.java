package com.shanuka_spring.shanuka_spring_3.service;

import com.shanuka_spring.shanuka_spring_3.dto.UserDto;
import com.shanuka_spring.shanuka_spring_3.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserEntity register(UserDto userDto);
    UserEntity login(String userName);
}

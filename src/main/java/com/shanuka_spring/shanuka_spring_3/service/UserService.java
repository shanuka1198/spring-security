package com.shanuka_spring.shanuka_spring_3.service;

import com.shanuka_spring.shanuka_spring_3.dto.UserDto;
import com.shanuka_spring.shanuka_spring_3.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User register(UserDto userDto);
    User login(String userName);
}

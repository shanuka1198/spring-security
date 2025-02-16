package com.shanuka_spring.shanuka_spring_3.service.impl;

import com.shanuka_spring.shanuka_spring_3.dto.UserDto;
import com.shanuka_spring.shanuka_spring_3.entity.User;
import com.shanuka_spring.shanuka_spring_3.repository.UserRepository;
import com.shanuka_spring.shanuka_spring_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(UserDto userDto) {
        User user=new User(
                userDto.getUserId(),
                userDto.getUserName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
        return userRepository.save(user);
    }

    @Override
    public User login(String userName) {
        User user= userRepository.findByUserName(userName);
        return user;
    }
}

package com.shanuka_spring.shanuka_spring_3.service.impl;

import com.shanuka_spring.shanuka_spring_3.dto.UserDto;
import com.shanuka_spring.shanuka_spring_3.entity.UserEntity;
import com.shanuka_spring.shanuka_spring_3.repository.UserRepository;
import com.shanuka_spring.shanuka_spring_3.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity register(UserDto userDto) {
        UserEntity userEntity =new UserEntity(
                userDto.getUserId(),
                userDto.getUsername(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getRole());


        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity login(String username) {
        return userRepository.findByUserName(username).orElse(null);

    }
}

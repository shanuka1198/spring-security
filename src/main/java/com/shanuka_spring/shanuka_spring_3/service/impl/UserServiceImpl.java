package com.shanuka_spring.shanuka_spring_3.service.impl;

import com.shanuka_spring.shanuka_spring_3.dto.UserDto;
import com.shanuka_spring.shanuka_spring_3.entity.UserEntity;
import com.shanuka_spring.shanuka_spring_3.repository.UserRepository;
import com.shanuka_spring.shanuka_spring_3.service.JwtService;
import com.shanuka_spring.shanuka_spring_3.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
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
    public String login(UserEntity user) {
                Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
        );
//        UserEntity userEntity = userRepository.findByUserName(user.getUsername()).orElse(null);
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user);
        }
        return "fail";
    }

//        Authentication authentication=authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
//        );
//
//        if (authentication.isAuthenticated()){
//            return jwtService.generateToken(user);
//        }
//        return "fail";
//
//    }
}

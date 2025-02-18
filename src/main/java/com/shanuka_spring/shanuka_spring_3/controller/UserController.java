package com.shanuka_spring.shanuka_spring_3.controller;

import com.shanuka_spring.shanuka_spring_3.dto.UserDto;
import com.shanuka_spring.shanuka_spring_3.entity.UserEntity;
import com.shanuka_spring.shanuka_spring_3.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {


    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user) {
        return userService.login(user);
    }

}

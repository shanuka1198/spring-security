package com.shanuka_spring.shanuka_spring_3.service;

import com.shanuka_spring.shanuka_spring_3.entity.UserEntity;

import com.shanuka_spring.shanuka_spring_3.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity =userRepository.findByUserName(username).orElse(null);
        if (userEntity ==null){
            throw new UsernameNotFoundException("user not found");
        }

        UserDetails user= User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();

        return user;
    }
}

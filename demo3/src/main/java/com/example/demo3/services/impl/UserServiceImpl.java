package com.example.demo3.services.impl;

import com.example.demo3.persistense.entities.UserRepository;
import com.example.demo3.dto.request.UserLoginDTO;
import com.example.demo3.dto.response.UserDto;
import com.example.demo3.persistense.entities.User;
import com.example.demo3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto create() {
        return new UserDto("Bruce", "Waine");
    }

    @Override
    public Boolean login() {
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public User save(UserLoginDTO userLoginDto) {
       return new User("username", "password", "email");
    }
}

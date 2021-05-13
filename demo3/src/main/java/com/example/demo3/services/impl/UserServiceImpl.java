package com.example.demo3.services.impl;

import com.example.demo3.UserRepository;
import com.example.demo3.dto.request.UserLoginDto;
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
    public User save(UserLoginDto userLoginDto) {
        return userRepository.save(new User(
                userLoginDto.getUsername(),
                userLoginDto.getPassword()
        ));
    }
}

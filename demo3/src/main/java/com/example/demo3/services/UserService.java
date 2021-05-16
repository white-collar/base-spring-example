package com.example.demo3.services;

import com.example.demo3.dto.request.UserLoginDTO;
import com.example.demo3.dto.response.UserDto;
import com.example.demo3.persistense.entities.User;

public interface UserService {
    UserDto create();
    Boolean login();
    void logout();
    User save(UserLoginDTO userLoginDto);
}

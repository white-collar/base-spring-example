package com.example.demo3.controllers;

import com.example.demo3.dto.request.UserLoginDto;
import com.example.demo3.dto.response.UserDto;
import com.example.demo3.helper.UserMapper;
import com.example.demo3.persistense.entities.User;
import com.example.demo3.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("api/users")
@RestController
public class UsersController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto login(@RequestBody UserLoginDto userLoginDto) {
        return userMapper
                .mapToUserDto(userService.save(userLoginDto));
    }

    @GetMapping
    public List<String> getUsers(){
        return Arrays.asList("Batman", "Cyborg", "Superman", "Wonderwoman");
    }

}

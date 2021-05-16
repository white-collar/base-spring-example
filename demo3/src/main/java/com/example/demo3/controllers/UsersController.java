package com.example.demo3.controllers;

import com.example.demo3.dto.request.UserDataDTO;
import com.example.demo3.dto.request.UserLoginDTO;
import com.example.demo3.persistense.entities.User;
import com.example.demo3.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("api/users")
@RestController
public class UsersController {

    @Autowired
    UserService userService;


    @PostMapping("/signup")
    public String signup(@RequestBody UserDataDTO user) {
        return userService.signup(new User(user.getUsername(), user.getPassword(), user.getEmail()));
    }

    @PostMapping("/signin")
    public String login(@RequestBody UserLoginDTO userLoginDto) throws AuthenticationException {
        return userService.signin(userLoginDto.getUsername(), userLoginDto.getPassword());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/get")
    public List<User> getUsers(){
        return Arrays.asList(new User("1", "2", "3"));
    }

}

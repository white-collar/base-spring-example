package com.example.demo3.controllers;

import com.example.demo3.dto.request.UserDataDTO;
import com.example.demo3.exceptions.CustomException;
import com.example.demo3.persistense.entities.User;
import com.example.demo3.services.impl.UserServiceImpl;
import com.example.demo3.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("api/users")
@RestController
public class UsersController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    UserService userService;

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/signup")
    public String signup(@RequestBody UserDataDTO user) {
        return userService.signup(new User(user.getUsername(), user.getPassword(), user.getEmail()));
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) throws Exception{
        Optional<User> optionalUser = userServiceImpl.getUser(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else throw new CustomException("User not found", HttpStatus.NOT_FOUND);
    };


    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping()
    public Page<User> getUsers(Pageable pageable){
        String app = applicationContext.getDisplayName();
        String[] beans =  applicationContext.getBeanDefinitionNames();
        for (String bean: beans) {
            System.out.println(bean);
        }
        return userServiceImpl.getUsers(pageable);
    }

}

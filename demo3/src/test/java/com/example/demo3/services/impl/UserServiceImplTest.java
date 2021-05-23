package com.example.demo3.services.impl;

import com.example.demo3.persistense.entities.User;
import com.example.demo3.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUsers() {

        userRepository.save(new User("username", "email", "password"));

        Page<User> pagedUser = userService.getUsers(PageRequest.of(0, 10));

        Assertions.assertEquals(pagedUser.getTotalPages(), 1);
    }

    @Test
    void getUser() {
    }
}

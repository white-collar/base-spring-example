package com.example.demo3.services.impl;

import com.example.demo3.repository.UserRepository;
import com.example.demo3.dto.response.UserDto;
import com.example.demo3.persistense.entities.User;
import com.example.demo3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }


}

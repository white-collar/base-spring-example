package com.example.demo3.services;

import com.example.demo3.dto.response.UserDto;
import com.example.demo3.persistense.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserDto create();
    Boolean login();
    void logout();
    Page<User> getUsers(Pageable pageable);
    Optional<User> getUser(Integer id);
}

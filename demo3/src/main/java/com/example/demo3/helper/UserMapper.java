package com.example.demo3.helper;

import com.example.demo3.dto.response.UserDto;
import com.example.demo3.persistense.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDto mapToUserDto(User user){
        return new UserDto(
               user.getUsername(),
               user.getPassword()
        );
    }
}

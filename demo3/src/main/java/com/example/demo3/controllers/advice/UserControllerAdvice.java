package com.example.demo3.controllers.advice;

import com.example.demo3.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(value = CustomException.class)
    ResponseEntity<String> userNotFoundResponse() {
        return new
                ResponseEntity<String>("Really sorry user is not found hope you will cope with this ",
                HttpStatus.UNPROCESSABLE_ENTITY);

    }

}

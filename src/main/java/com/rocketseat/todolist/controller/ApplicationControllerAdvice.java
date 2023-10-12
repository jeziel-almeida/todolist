package com.rocketseat.todolist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rocketseat.todolist.exception.InvalidTaskDateException;
import com.rocketseat.todolist.exception.TaskNotFoundException;
import com.rocketseat.todolist.exception.UserNotAllowedException;
import com.rocketseat.todolist.exception.UsernameAlreadyRegisteredException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    
    @ExceptionHandler(UsernameAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleUsernameAlreadyRegistered(UsernameAlreadyRegisteredException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidTaskDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidTaskDateException(InvalidTaskDateException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(UserNotAllowedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleUserNotAllowedException(UserNotAllowedException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleTaskNotFoundException(TaskNotFoundException ex) {
        return ex.getMessage();
    }
}

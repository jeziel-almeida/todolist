package com.rocketseat.todolist.exception;

public class UsernameAlreadyRegisteredException extends RuntimeException {
    
    public UsernameAlreadyRegisteredException() {
        super("Username já cadastrado!");
    }
}

package com.rocketseat.todolist.exception;

public class UserNotAllowedException extends RuntimeException {
    
    public UserNotAllowedException() {
        super("Usuário não tem autorização para realizar essa operação!");
    }
}

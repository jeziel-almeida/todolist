package com.rocketseat.todolist.exception;

public class UserNotAllowedException extends RuntimeException {
    
    public UserNotAllowedException() {
        super("Usuário não autorizado! Verifique username e senha e tente novamente.");
    }
}

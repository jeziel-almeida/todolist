package com.rocketseat.todolist.exception;

public class InvalidTaskDateException extends RuntimeException {
    
    public InvalidTaskDateException(String message) {
        super(message);
    }
}

package com.rocketseat.todolist.exception;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {
    
    public TaskNotFoundException(UUID id) {
        super("Task não encontrada com o id: " + id);
    }
}

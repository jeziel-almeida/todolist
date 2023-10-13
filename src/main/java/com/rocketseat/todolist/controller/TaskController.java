package com.rocketseat.todolist.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.todolist.model.Task;
import com.rocketseat.todolist.service.TaskService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody @Valid Task task, HttpServletRequest request) {

        return taskService.create(task, request);
    }

    @GetMapping
    public List<Task> listByIdUser(HttpServletRequest request) {

        return this.taskService.listByIdUser(request);
    }

    @PutMapping("/{id}")
    public Task update(@RequestBody Task task, @PathVariable UUID id, HttpServletRequest request) {
        
        return this.taskService.update(task, id, request);
    }
}

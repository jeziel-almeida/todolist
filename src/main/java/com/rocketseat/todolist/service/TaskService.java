package com.rocketseat.todolist.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.todolist.exception.InvalidTaskDateException;
import com.rocketseat.todolist.exception.TaskNotFoundException;
import com.rocketseat.todolist.exception.UserNotAllowedException;
import com.rocketseat.todolist.model.Task;
import com.rocketseat.todolist.repository.TaskRepository;
import com.rocketseat.todolist.utils.Utils;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task create(Task task, HttpServletRequest request) {

        task.setIdUser(this.getIdUserFromRequest(request));

        //Date validation
        var currentDate = LocalDateTime.now();
        if (currentDate.isAfter(task.getStartAt()) || currentDate.isAfter(task.getEndAt()))
            throw new InvalidTaskDateException("As datas de início e de término devem ser maiores do que a atual.");
        if (task.getStartAt().isAfter(task.getEndAt())) throw new InvalidTaskDateException("A data de início deve ser menor que a data de término.");

        return this.taskRepository.save(task);
    }

    public List<Task> listByIdUser(HttpServletRequest request) {
        
        UUID idUser = this.getIdUserFromRequest(request);
        return this.taskRepository.findByIdUser(idUser);
    }

    public Task update(Task task, UUID id, HttpServletRequest request) {

        Task taskBD = this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

        UUID idUser = this.getIdUserFromRequest(request);
        
        if (!taskBD.getIdUser().equals(idUser)) throw new UserNotAllowedException();

        Utils.copyNonNullProperties(task, taskBD);

        return this.taskRepository.save(taskBD);
    }


    private UUID getIdUserFromRequest(HttpServletRequest request) {
        return (UUID) request.getAttribute("idUser");
    }
}

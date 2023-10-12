package com.rocketseat.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocketseat.todolist.model.Task;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findByIdUser(UUID idUser);

}

package com.polytech.polytoDo.repository;

import com.polytech.polytoDo.business.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll(String username);

    void add(Task task, String username);
    void edit(Task task);
    void done(Task task);
    void delete(int id, String username);

    Task findById(int id);
}

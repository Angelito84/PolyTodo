package com.polytech.polytoDo.business;

public interface TaskService {
    void add(Task task, String username);
    void done(Task task);
    void edit(Task task);
    void delete(int id, String username);
    Task findById(int id);
}

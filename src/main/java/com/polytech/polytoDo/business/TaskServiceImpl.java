package com.polytech.polytoDo.business;

import com.polytech.polytoDo.repository.TaskRepository;

public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void add(Task task, String username) {
        taskRepository.add(task, username);
    }

    @Override
    public void done(Task task) {
        taskRepository.done(task);
    }

    @Override
    public void edit(Task task) {
        taskRepository.edit(task);
    }

    @Override
    public void delete(int id, String username) {
        taskRepository.delete(id, username);
    }

    @Override
    public Task findById(int id) {
        return taskRepository.findById(id);
    }
}

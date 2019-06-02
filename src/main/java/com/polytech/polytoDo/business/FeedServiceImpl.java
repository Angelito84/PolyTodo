package com.polytech.polytoDo.business;

import com.polytech.polytoDo.repository.TaskRepository;

import java.util.List;

public class FeedServiceImpl implements FeedService {
    private TaskRepository taskRepository;

    public FeedServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> fetchAll(String username) {
        return taskRepository.findAll(username);
    }
}

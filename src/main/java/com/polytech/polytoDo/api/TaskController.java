package com.polytech.polytoDo.api;

import com.polytech.polytoDo.business.*;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class TaskController {
    private FeedService feedService;
    private TaskService taskService;

    public TaskController(FeedService feedService, TaskService taskService) {
        this.feedService = feedService;
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> fetchAll(Principal principal) {
        return feedService.fetchAll(principal.getName());
    }

    @PostMapping("/addTask")
    public void add(@RequestBody Task task, Principal principal) {
        taskService.add(task, principal.getName());
    }

    @PutMapping("/editTask")
    public void edit(@RequestBody Task task) {
        taskService.edit(task);
    }

    @PutMapping("/doneTask")
    public void done(@RequestBody Task task) {
        taskService.done(task);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void delete(@PathVariable int id, Principal principal) {
        taskService.delete(id, principal.getName());
    }
}
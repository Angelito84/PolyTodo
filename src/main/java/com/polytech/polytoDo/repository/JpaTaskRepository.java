package com.polytech.polytoDo.repository;

import com.polytech.polytoDo.business.Task;
import com.polytech.polytoDo.business.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class JpaTaskRepository implements TaskRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Task> findAll(String username) {
        User user = entityManager.find(User.class, username);
        return user.getTaskList();
    }

    @Override
    public void add(Task task, String username) {
        User user = entityManager.find(User.class, username);
        user.getTaskList().add(task);
    }

    @Override
    public void edit(Task task) {
        Task taskEdit = entityManager.find(Task.class, task.getId());
        taskEdit.setContent(task.getContent());
    }

    @Override
    public void done(Task task) {
        Task taskDone = entityManager.find(Task.class, task.getId());
        taskDone.setDone(task.isDone());
    }

    @Override
    public void delete(int id, String username) {
        Task task = entityManager.find(Task.class, id);
        User user = entityManager.find(User.class, username);
        user.getTaskList().remove(task);
    }

    @Override
    public Task findById(int id)  {
        return entityManager.find(Task.class, id);
    }
}

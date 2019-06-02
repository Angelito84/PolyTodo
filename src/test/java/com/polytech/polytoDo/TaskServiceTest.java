package com.polytech.polytoDo;

import com.polytech.polytoDo.business.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureDataJpa
@Transactional
public class TaskServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FeedService feedService;


    @Test
    public void should_fetch_tasks_feed() throws UsernameAlreadyExistsException {

        //GIVEN
        User user1 = new User("user1", "mdp_user1");
        userService.addUser(user1);
        Task task1 = new Task("task1");
        taskService.add(task1,"user1");
        Task task2 = new Task("task1");
        taskService.add(task2,"user1");
        Task task3 = new Task("task1");
        taskService.add(task3,"user1");


        //WHEN
        List<Task> tasks = feedService.fetchAll("user1");

        //THEN
        Assert.assertEquals(3, tasks.size());
        Assert.assertEquals(Arrays.asList(task1, task2, task3), tasks);
    }
}

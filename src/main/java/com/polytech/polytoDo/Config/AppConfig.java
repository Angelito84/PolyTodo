package com.polytech.polytoDo.Config;

import com.polytech.polytoDo.business.*;
import com.polytech.polytoDo.repository.JpaTaskRepository;
import com.polytech.polytoDo.repository.JpaUserRepository;
import com.polytech.polytoDo.repository.TaskRepository;
import com.polytech.polytoDo.repository.UserRepository;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Bean
    TaskRepository taskRepository() {
        return new JpaTaskRepository();
    }

    @Bean
    UserRepository userRepository(){
        return new JpaUserRepository();
    }

    @Bean
    DataSource datasource() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://mysql-angel.alwaysdata.net:3306/angel_todolist");
            dataSource.setUser("angel_todolist");
            dataSource.setPassword("C3eCC46piByLUXa");
            dataSource.setDatabaseName("angel_todolist");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return dataSource;
    }

    @Bean
    UserService userService(){
        return new UserServiceImpl(userRepository());
    }

    @Bean
    FeedService feedService() {
        return new FeedServiceImpl(taskRepository());
    }

    @Bean
    TaskService taskService() {
        return new TaskServiceImpl(taskRepository());
    }
}

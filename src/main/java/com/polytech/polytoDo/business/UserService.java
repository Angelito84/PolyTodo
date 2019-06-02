package com.polytech.polytoDo.business;

public interface UserService {
    void addUser(User user) throws UsernameAlreadyExistsException;
    User findByUsername(String username);
}

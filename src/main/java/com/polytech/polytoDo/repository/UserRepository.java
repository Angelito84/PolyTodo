package com.polytech.polytoDo.repository;

import com.polytech.polytoDo.business.User;
import com.polytech.polytoDo.business.UsernameAlreadyExistsException;

public interface UserRepository {
    void add(User user) throws UsernameAlreadyExistsException;
    User findByUsername(String username);
}

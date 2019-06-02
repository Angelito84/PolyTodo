package com.polytech.polytoDo.business;

public class UsernameAlreadyExistsException extends Exception {
    public UsernameAlreadyExistsException(String username) {
        super(username + " is already used !");
    }
}

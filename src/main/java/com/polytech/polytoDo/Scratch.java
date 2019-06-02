package com.polytech.polytoDo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Scratch {
    public static void main(String[] args) {
        String hash = new BCryptPasswordEncoder().encode("password");
        System.out.println(hash);
    }
}

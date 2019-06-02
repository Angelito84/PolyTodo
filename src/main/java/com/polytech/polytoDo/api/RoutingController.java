package com.polytech.polytoDo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {

    @GetMapping("/register")
    public String register(){
        return "/register.html";
    }

    @GetMapping("/login")
    public String login(){
        return "/login.html";
    }

    @GetMapping("/login?error")
    public String loginError() {
        return "/login.html";
    }

    @GetMapping("/feed")
    public String feed(){
        return "/feed.html";
    }

    @GetMapping("/")
    public String index() {
        return "/index.html";
    }
}

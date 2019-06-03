package com.polytech.polytoDo.api;

import com.polytech.polytoDo.business.Authority;
import com.polytech.polytoDo.business.User;
import com.polytech.polytoDo.business.UserService;
import com.polytech.polytoDo.business.UsernameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Collections;
import java.util.Optional;

@RestController
public class LoginController {
    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/loggedUser")
    public Optional<String> currentUserName(Principal principal) {
        return Optional.ofNullable(principal.getName());
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setEnabled(true);
        user.setAuthoritySet(Collections.singleton(new Authority("user", user)));
        try {
            userService.addUser(user);
        } catch (UsernameAlreadyExistsException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/findUser")
    public User findByUsername(String username) {
        return userService.findByUsername(username);
    }
}

package com.treknuts.glucoseapi.controllers;

import com.treknuts.glucoseapi.models.User;
import com.treknuts.glucoseapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public @ResponseBody String addNewUser(@RequestParam String username,
                                          @RequestParam String email,
                                          @RequestParam String password) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);
        userRepository.addUser(username, email, password);
        return "User Registered successfully";
    }

    @PostMapping("/login")
    public @ResponseBody String login(@RequestParam String username, @RequestParam String password) {
        return userRepository.getUserByUsername(username).toString();
    }
}

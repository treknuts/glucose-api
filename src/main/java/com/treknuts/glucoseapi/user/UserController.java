package com.treknuts.glucoseapi.user;

import com.treknuts.glucoseapi.models.User;
import com.treknuts.glucoseapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
}

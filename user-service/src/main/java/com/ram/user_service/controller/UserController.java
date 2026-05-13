package com.ram.user_service.controller;

import com.ram.user_service.model.Users;
import com.ram.user_service.model.UsersLogin;
import com.ram.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping("/")
    public String test(){
        return "Welcome to user service";
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UsersLogin user){
        return userService.loginUser(user);
    }

    @GetMapping("/getUsers")
    public List<Users> getUsers(){
        return userService.getUsers();
    }

}

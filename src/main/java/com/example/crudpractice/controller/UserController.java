package com.example.crudpractice.controller;

import com.example.crudpractice.service.UserService;
import com.example.crudpractice.model.user;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<user> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public user createUser(@RequestBody user user){
        return userService.createUser(user);
    }

    @PostMapping("/{id}")
    public user updateUser(@PathVariable Long id, @RequestBody user user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}

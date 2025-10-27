package com.example.crudpractice.controller;

import com.example.crudpractice.repository.UserRepository;
import com.example.crudpractice.model.user;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public List<user> GetAllUsers(){
        return repo.findAll();
    }

    @PostMapping
    public user CreateUser(@RequestBody user user){
        return repo.save(user);
    }

    @GetMapping("/{id}")
    public user getUserById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        repo.deleteById(id);
    }
}

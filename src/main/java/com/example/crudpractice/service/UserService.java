package com.example.crudpractice.service;

import com.example.crudpractice.model.user;
import com.example.crudpractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<user> getAllUsers(){
        return userRepository.findAll();
    }

    public user getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No user with id: " + id));
    }

    public user createUser(user user){
        return userRepository.save(user);
    }

    public user updateUser(Long id, user updatedUser){
        return userRepository.findById(id).map(user ->{
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new NoSuchElementException("User not Found with id:" + id));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}

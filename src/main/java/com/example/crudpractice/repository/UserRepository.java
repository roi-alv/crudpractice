package com.example.crudpractice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudpractice.model.user;
public interface UserRepository extends JpaRepository<user, Long> {

}

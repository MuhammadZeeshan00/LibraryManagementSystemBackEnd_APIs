package com.example.library.Repository;

import com.example.library.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
    Optional<User> findbyEmail(String Email);
}

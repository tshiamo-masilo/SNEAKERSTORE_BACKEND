package com.sneaker.store.controller;


import com.sneaker.store.model.User;
import com.sneaker.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/user")
@AllArgsConstructor
public class UserControl {

    private final UserRepository userRepository;
    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("user/{id}")
    public Optional<User> getUser(@PathVariable String userId){
        return userRepository.findById(Long.valueOf(userId));
    }
}
//TODO
package com.sneaker.store.controller;


import com.sneaker.store.model.User;
import com.sneaker.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public void createUser(@RequestBody User user){
        userRepository.save(user);
    }

    @DeleteMapping("/user/delete:{id}")
    public Optional<User> deleteUser(@PathVariable("id") Long id){
        Optional<User> user = userRepository.findById(id);
        userRepository.deleteById(id);
        return user;
    }
}
//TODO
package com.rocketseat.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.todolist.exception.UsernameAlreadyRegisteredException;
import com.rocketseat.todolist.model.User;
import com.rocketseat.todolist.repository.UserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        User userBase = this.findByUsername(user.getUsername());

        if (userBase != null) {
            throw new UsernameAlreadyRegisteredException();
        }

        var hash = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(hash);
    
        return this.userRepository.save(user);       
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
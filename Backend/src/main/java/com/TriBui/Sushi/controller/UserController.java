/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TriBui.Sushi.controller;

import com.TriBui.Sushi.model.User;
import com.TriBui.Sushi.dal.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author This MC
 */
@RestController
public class UserController {
    
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    
    @PostMapping ("/users")
    @ResponseStatus (HttpStatus.CREATED)
    @Transactional (propagation = Propagation.REQUIRES_NEW)
    public void registerUser (@RequestBody User user) {
        String userID;
        boolean userAlreadyExisted;
        userID = user.getUserID();
        userAlreadyExisted = userRepository.existsById(userID);
        if (userAlreadyExisted == true) {
            throw new RuntimeException();
        } else {
            userRepository.save(user);
        }
    }
}

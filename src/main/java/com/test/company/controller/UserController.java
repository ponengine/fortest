/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.company.controller;

import com.test.company.domain.BaseRestApi;
import com.test.company.dto.UserDTO;
import com.test.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author OREOPON
 */
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public BaseRestApi get() {
        return userService.get();
    }

    @PostMapping("/register")
    public BaseRestApi insert(@RequestBody UserDTO user) {
        return userService.register(user);
    }

    @PutMapping("/update")
    public BaseRestApi update(@RequestBody UserDTO user) {
        return userService.update(user);
    }

    @DeleteMapping("/delete/id")
    public BaseRestApi delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}

package com.chat.controller;

import com.chat.model.User;
import com.chat.service.UserService;
import com.chat.util.Exception.UserAlreadyExistException;
import com.chat.util.Exception.UserCredentialsIncorrectException;
import com.chat.util.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello(){
        System.out.println("Hello");
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        System.out.println("register");
        try {
            userService.registerUser(user);
            return ResponseEntity.ok().body("created successfully");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user){
        try{
            userService.loginUser(user);
            return ResponseEntity.ok().body("logged in successfully!");
        }catch (UserCredentialsIncorrectException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (UserNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}

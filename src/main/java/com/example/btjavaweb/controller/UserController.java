package com.example.btjavaweb.controller;

import com.example.btjavaweb.dto.UserRequest;
import com.example.btjavaweb.entity.Users;
import com.example.btjavaweb.service.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UsersServiceImpl usersService;
    @PostMapping("/login")
    @CrossOrigin
    ResponseEntity<Users> login(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok().body(usersService.login(userRequest));
    }
    @PostMapping("/register")
    @CrossOrigin
    ResponseEntity<Users> register(@RequestBody Users users){
        return ResponseEntity.ok().body(usersService.register(users));
    }

}

package com.example.btjavaweb.service;


import com.example.btjavaweb.dto.UserRequest;
import com.example.btjavaweb.entity.Users;

public interface UsersService {
    Users login(UserRequest userRequest);
    Users register(Users user);

    Users getUserById(Long id);

}

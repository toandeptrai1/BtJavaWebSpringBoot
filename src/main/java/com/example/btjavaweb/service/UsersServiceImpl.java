package com.example.btjavaweb.service;

import com.example.btjavaweb.dto.UserRequest;
import com.example.btjavaweb.entity.Users;
import com.example.btjavaweb.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepo;


    @Override
    public Users login(UserRequest userRequest) {

        return usersRepo.findByUsernameAndPassword(userRequest.getUsername(),userRequest.getPassword());
    }

    @Override
    public Users register(Users user) {
        if(usersRepo.existsByUsername(user.getUsername())){
            return null;
        }
        user.setRole("user");
        return usersRepo.save(user);
    }

    @Override
    public Users getUserById(Long id) {
        return usersRepo.findById(id).orElse(null);
    }
}

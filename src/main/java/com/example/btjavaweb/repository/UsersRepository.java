package com.example.btjavaweb.repository;

import com.example.btjavaweb.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByUsernameAndPassword(String userName,String password);
    Boolean existsByUsername(String userName);
}

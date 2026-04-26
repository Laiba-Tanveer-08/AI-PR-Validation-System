package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findByName(String name);
    List<Users> findByNameContaining(String name);
    List<Users> findByNameStartingWith(String name);
    List<Users> findByNameEndingWith(String name);
}
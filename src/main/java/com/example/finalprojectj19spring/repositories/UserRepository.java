package com.example.finalprojectj19spring.repositories;

import com.example.finalprojectspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/29/2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
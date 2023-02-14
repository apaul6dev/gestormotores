package com.grapes.mmotor.security.dao;

import java.util.Optional;

import com.grapes.mmotor.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}

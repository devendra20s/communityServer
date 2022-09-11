package com.communityServer.repository;

import com.communityServer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAll();

    User findByEmail(String email);

    User findUserByEmail(String email);
}

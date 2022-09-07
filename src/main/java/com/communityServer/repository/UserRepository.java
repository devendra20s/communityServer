package com.communityServer.repository;

import com.communityServer.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
    List<UserModel> findAll();

    UserModel findByEmail(String email);

    UserModel findUserByEmail(String email);
}

package com.hoaxify.ws.dao;

import com.hoaxify.ws.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String userName);

    User findByUsername(String userName);
}

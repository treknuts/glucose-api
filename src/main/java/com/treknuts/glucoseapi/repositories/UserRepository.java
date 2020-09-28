package com.treknuts.glucoseapi.repositories;

import com.treknuts.glucoseapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u FROM users u WHERE u.username = :username", nativeQuery = true)
    User getUserByUsername(@Param("username") String username);

    @Query(value = "INSERT INTO users (username, email, password) VALUES (:username, :email, :password)", nativeQuery = true)
    User addUser(@Param("username") String username, @Param("email") String email, @Param("password") String password);
}

package com.trust.spring_myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trust.spring_myapp.domain.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    //ポイント①
    @Query("SELECT u FROM Customer ORDER BY u.id")
    List<Users> findAllOrderById();
}
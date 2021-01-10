package com.example.tisuUserApp.repository;

import com.example.tisuUserApp.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface UserRepository extends JpaRepository<users, BigInteger> {
    List<users> findByuserId(BigInteger id);
    List<users> findBycourseId(BigInteger id);
}

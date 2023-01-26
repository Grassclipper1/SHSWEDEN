package com.example.SHSWEDEN.Repos;

import com.example.SHSWEDEN.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
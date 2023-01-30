package com.example.SHSWEDEN.Repos;

import com.example.SHSWEDEN.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmailAddress(String emailAddress);
    List<User> findByEmailAddressAndPassword(String emailAddress, String password);



}
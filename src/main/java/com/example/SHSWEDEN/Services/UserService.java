package com.example.SHSWEDEN.Services;


import com.example.SHSWEDEN.Entities.User;
import com.example.SHSWEDEN.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User getUser(Integer id) {

        User user = userRepository.findById(id).get();

        return user;
    }

    public User findByEmailAddressAndPassword(String emailAddress, String password){
        List<User> userList = userRepository.findByEmailAddressAndPassword(emailAddress, password);
        User user = userList.stream().findFirst()
                .orElse(null);

        return user;
    }

    public  User findById(int id) {
        User user = userRepository.findById(id).orElse(null);

        return user;

    }


}
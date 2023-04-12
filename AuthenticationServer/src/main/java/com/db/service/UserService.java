package com.db.service;


import com.db.entity.User;
import com.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findByUserId(int userId) {
        return userRepository.findById(userId);
    }
    public Optional<User> findByName(String name){
        return userRepository.findByName(name);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int userId, User user) {
        int id = userId;
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();

        userRepository.updateUser(id,name,email,password);
        return user;
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}
